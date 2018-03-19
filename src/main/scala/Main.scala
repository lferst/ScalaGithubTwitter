/**
  * Class searches for projects on GitHub, then for each project found searches Twitter for
  * tweets that mention it and finally as an output print a summary of each project with a
  * short list of recent tweets, in JSON format.
  *
  *  @author Lucas Ferst
  *
  **/
import com.typesafe.config.ConfigFactory
import reactive._
import reactive.connection.real.{RealGithubConnection, RealTwitterConnection}
import reactive.util.JsonUtil

object Main extends App {

    //Loading application config
    val conf = ConfigFactory.load()

    var searchKey : String = conf.getString("reactive.searchKey")

    val tweets = new DataSearcher(new RealTwitterConnection(),new RealGithubConnection()).search(searchKey)

    //Printing Output
    println(new JsonUtil()buildJson(Map("Projects" -> tweets)))


  }


