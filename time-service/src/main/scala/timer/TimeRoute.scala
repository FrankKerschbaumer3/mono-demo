package timer

import java.time.LocalDate

import akka.http.scaladsl.server.{Directives, Route}

case class Time(time: String)

trait TimeJsonSupport extends JsonSupport {
  implicit val timeFormat = jsonFormat1(Time)
}

object TimeRoute extends Directives with TimeJsonSupport {
  def apply(): Route =
    get {
      complete(Time(LocalDate.now().toString))
    }
}