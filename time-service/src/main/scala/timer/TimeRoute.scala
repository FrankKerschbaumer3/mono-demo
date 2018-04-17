package timer

import java.time.LocalDateTime

import akka.http.scaladsl.server.{Directives, Route}

case class Time(time: String)

sealed trait TimeJsonSupport extends JsonSupport {
  implicit val timeFormat = jsonFormat1(Time)
}

object TimeRoute extends Directives with TimeJsonSupport {
  def apply(): Route =
    get {
      complete(Time(LocalDateTime.now().toString))
    }
}