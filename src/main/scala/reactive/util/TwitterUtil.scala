/**
  * Utility Class for Interaction with Twitter
  *
  * @author Lucas Ferst
  *
  **/
package reactive.util

import reactive.connection.TwitterConnection
import reactive.pojos.{Tweet, Tweets}

/**
  * @param twitterConnection
  *                          Twitter Connection Instance
  **/
class TwitterUtility (twitterConnection: TwitterConnection){

  /**
    * Return List of Project Tweets.
    *
    * @param projectName
    *             Project Name
    * @param projectDescription
    *             Project Description
    * @return
    *             List of Tweets
    *
    **/
    def getProjectTweets(projectName: String, projectDescription: String): Tweets = {

    val listTweets = for (tweet <- twitterConnection.connectTwitterAndSearchForTweets(projectName)) yield new Tweet(tweet.getUser().getScreenName, tweet.getText)
    new Tweets(projectName, projectDescription, listTweets)

  }





}
