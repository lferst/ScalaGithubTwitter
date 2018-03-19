
/**
  * Utility Class for Json Marshall Operations
  *
  *  @author Lucas Ferst
  *
  **/
package reactive.util

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import reactive.pojos.{Github, Tweets}


class JsonUtil {

  /**
    * UnMarshal Json String to a Github Object.
    *
    * @param json
    *             Json String to be unMarshelled
    * @return
    *         unMarshelled Github object
    *
    **/
  def unMarshalGithubJson(json: String): Github = {

    val mapper = new ObjectMapper with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue[Github](json)
  }

  /**
    * Builds Json String and return it
    *
    * @param json
    *
    *          <b>Args ex.:</b> Map <'Projects', Seq(Tweets)>
    *          <p>
    *          <b>This Map will eventually be converted into a JSON and returned as a
    *          String:</b>
    *          <p>
    *          { "Projects":[ { "attribute1":"XXXXXXXX",
    *          "attribute2":"XXXXXXXX", "attribute3":"XXXXXXXX"
    *
    *          } ] }
    *
    * @return String containing built Object
    *
    **/
  def buildJson(json: Map[String, Seq[Tweets]]): String = {

    val mapper = new ObjectMapper with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.writeValueAsString(json)
  }

}
