/**
  * Tweets Pojo
  *
  *  @author Lucas Ferst
  *
  **/
package reactive.pojos

import jdk.nashorn.internal.ir.annotations.Immutable


@Immutable
class Tweets(val name: String, val summary: String,val tweets: Seq[Tweet]) {

}
