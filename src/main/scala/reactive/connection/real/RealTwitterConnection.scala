/**
  * Utility Class for Interaction with Twitter
  *
  *  @author Lucas Ferst
  *
  **/
package reactive.connection.real

import com.typesafe.config.ConfigFactory
import reactive.connection.TwitterConnection
import twitter4j.auth.AccessToken
import twitter4j.{Query, Status, TwitterFactory}

import scala.collection.JavaConverters._

class RealTwitterConnection extends TwitterConnection {

  /**
    * @inheritdoc
    *
    **/
  def connectTwitterAndSearchForTweets(projectName: String):Seq[Status] = {

    val conf = ConfigFactory.load()

    val twitter = new TwitterFactory().getInstance
    twitter.setOAuthConsumer(conf.getString("reactive.tweeterDetails.consumerKey"), conf.getString("reactive.tweeterDetails.consumerSecret") )
    twitter.setOAuthAccessToken(new AccessToken(conf.getString("reactive.tweeterDetails.accessToken"), conf.getString("reactive.tweeterDetails.accessTokenSecret")))

    val tweets = twitter.search(new Query(projectName)).getTweets

    tweets.asScala

  }

}
