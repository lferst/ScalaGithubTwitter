package reactive.util

import org.scalamock.scalatest.MockFactory
import org.scalatest.FlatSpec
import reactive.connection.{GithubConnection, TwitterConnection}
import reactive.{DataSearcher}
import twitter4j.Status
import twitter4j.json.DataObjectFactory

class DataSearcherTest extends FlatSpec with MockFactory {

  "A Tweet List" should "return populated with Project Name and Summary along with one tweet" in {

    val fakeGithubConnection = stub[GithubConnection]
    val fakeTwitterConnection = stub[TwitterConnection]

    //Creating Fake Twitter4J Status
    val status: Status = DataObjectFactory.createStatus("{text='Fake', user={id=111111, name='Lucas',screenName='Lucas'}}")
    (fakeTwitterConnection.connectTwitterAndSearchForTweets _) when ("test") returns (Seq[Status](status))

    //Creating Fake Github Response
    val fakeGithubResponse = "{\"total_count\": 1,\"incomplete_results\": false, \"items\": [{\"id\": 1, \"name\": \"test\", \"full_name\": \"test\",\"description\": \"FakeProjectSummary\"}]}"
    (fakeGithubConnection.searchGitHubProjectsByName _) when ("test") returns (fakeGithubResponse)

    val tweets = new DataSearcher(fakeTwitterConnection, fakeGithubConnection).search("test")

    //Asserts
    for (item <- tweets){
      assert(item.name === "test")
      assert(item.summary === "FakeProjectSummary")
      for (itemInner <- item.tweets){
        assert(itemInner.text === "Fake")
      }
    }
  }

  }