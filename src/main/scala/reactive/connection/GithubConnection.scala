/**
  * Trait for Github Connection
  *
  * @author Lucas Ferst
  *
  **/
package reactive.connection

trait GithubConnection {

  /**
    * Searches GitHub Repository for projects matching given name.
    *
    * @param name
    *             Project Name
    * @return
    *         GitHub populated object containing list of projects
    *
    **/
  def searchGitHubProjectsByName(name: String):String

}
