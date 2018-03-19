/**
  * Utility Class for Interaction with Github
  *
  *  @author Lucas Ferst
  *
  **/
package reactive.connection.real

import com.softwaremill.sttp._
import reactive.connection.GithubConnection

class RealGithubConnection extends GithubConnection{

  /**
    * @inheritdoc
    *
    **/
  def searchGitHubProjectsByName(name: String):String = {

    val request = sttp.get(uri"https://api.github.com/search/repositories?q=$name")
    implicit val backend = HttpURLConnectionBackend()
    request.send().unsafeBody

  }

}
