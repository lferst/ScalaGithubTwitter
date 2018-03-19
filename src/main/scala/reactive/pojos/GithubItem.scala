/**
  * GithubItem Pojo
  *
  *  @author Lucas Ferst
  *
  **/
package reactive.pojos

import jdk.nashorn.internal.ir.annotations.Immutable


@Immutable
class GithubItem(val name: String, val full_name: String, val description: String){

}