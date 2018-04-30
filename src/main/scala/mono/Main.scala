package mono

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext

object Main extends Directives {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("TODO")
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    implicit val ec: ExecutionContext = system.dispatcher

    val routes =
      path("hello") {
        HelloRoute()
      }

    val bindingFuture = Http().bindAndHandle(routes, "0.0.0.0", 8080)

    bindingFuture.onComplete(_ => println("Server online on port :8080"))

    sys.addShutdownHook {
      bindingFuture
        .flatMap(_.unbind()) // trigger unbinding from the port
        .onComplete(_ => system.terminate()) // and shutdown when done
    }
  }
}
