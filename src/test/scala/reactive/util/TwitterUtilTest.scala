package reactive.util


import org.scalamock.scalatest.MockFactory
import org.scalatest._
import reactive.connection.TwitterConnection
import twitter4j.Status
import twitter4j.json.DataObjectFactory


class TwitterUtilTest extends FlatSpec with MockFactory {

  "A Tweet" should "return populated with text Fake after calling getProjectTweets" in {

    val fakeTwitterConnection = stub[TwitterConnection]

    //Creating Fake Twitter4J Status
    val status : Status= DataObjectFactory.createStatus("{text='Fake', user={id=111111, name='Lucas',screenName='Lucas'}}")
    (fakeTwitterConnection.connectTwitterAndSearchForTweets _) when("test") returns(Seq[Status](status))

    val tweets = new TwitterUtility(fakeTwitterConnection).getProjectTweets("test","test").tweets

    //Asserts
    for (item <- tweets){
      assert(item.text === "Fake")
    }


  }


}
