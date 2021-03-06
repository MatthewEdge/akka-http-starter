package medgelabs

import akka.http.scaladsl.server.{Directives, Route}

case class Hello(msg: String)

trait HelloJsonSupport extends JsonSupport {
  implicit val helloFormat = jsonFormat1(Hello)
}

object HelloRoute extends Directives with HelloJsonSupport {

  def apply(): Route =
    get {
      complete(Hello("Hello World!"))
    }
}