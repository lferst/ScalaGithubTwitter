/**
  * Data Searcher
  *
  * @author Lucas Ferst
  *
  **/
package reactive

import java.io.IOException

import reactive.connection.{GithubConnection, TwitterConnection}
import reactive.pojos.{Tweet, Tweets}
import reactive.util.{JsonUtil, TwitterUtility}
import twitter4j.TwitterException

/**
  * @param twitterConnection
  *                          Twitter Connection Instance
  * @param githubConnection
  *                          Github Connection Instance
  **/
class DataSearcher (twitterConnection: TwitterConnection, githubConnection: GithubConnection){


  /**
    * Searches GitHub Repository for projects matching given name and for each project found,
    * search Twitter for tweets that mention it
    *
    * @param projectName
    *             Project Name
    * @return
    *             List of Tweets
    *
    **/
  def search (projectName: String):Seq[Tweets] = {

    println(s"Getting list of Github projects related to $projectName")
    val githubResponse = new JsonUtil().unMarshalGithubJson(githubConnection.searchGitHubProjectsByName(projectName))

    println("Finding Tweets ...")

    try {
       val projectsTweets = for (item <- githubResponse.items) yield new TwitterUtility(twitterConnection).getProjectTweets(item.name, item.description)
       return projectsTweets
    } catch {
       case e: TwitterException =>  println("Error connecting to Twitter, please Verify user credentials in Application.conf")
    }

    Seq[Tweets]()
  }

}
