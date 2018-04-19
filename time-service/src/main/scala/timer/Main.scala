package timer

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext

object Main extends Directives {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("Timer")
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    implicit val ec: ExecutionContext = system.dispatcher

    val routes =
      path("time") {
        TimeRoute()
      }

    Http().bindAndHandle(routes, "0.0.0.0", 8080)
  }
}
