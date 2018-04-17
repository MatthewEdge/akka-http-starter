package mono

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer
import mono.hello.HelloRoute

import scala.concurrent.ExecutionContext
import scala.io.StdIn

object Main extends Directives {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("AppNameHere")
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    implicit val ec: ExecutionContext = system.dispatcher

    val routes =
      path("hello") {
        HelloRoute()
      }

    val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)

    println("Server online at http://localhost:8080/")
    println("Press RETURN to stop...")
    StdIn.readLine() // let it run until user presses return

    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
