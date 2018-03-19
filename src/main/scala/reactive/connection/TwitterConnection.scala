/**
  *  Trait for Twitter Connection and Direct Search
  *
  *  @author Lucas Ferst
  *
  **/
package reactive.connection

import twitter4j.Status

trait TwitterConnection {

  /**
    * Connect to Twitter using Application.conf values, searches for any tweet
    * related to given project name.
    *
    * @param projectName
    *         Project Name
    * @return
    *         List of Status
    *
    **/
  def connectTwitterAndSearchForTweets(projectName: String):Seq[Status]

}
