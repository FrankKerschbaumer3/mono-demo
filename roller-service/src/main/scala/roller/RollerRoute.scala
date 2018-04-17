package roller

import akka.http.scaladsl.server.{Directives, Route}
import roller.JsonSupport

case class Roll(dice: String, result: Int)

trait RollJsonSupport extends JsonSupport {
  implicit val rollFormat = jsonFormat1(Roll)
}

object RollerRoute extends Directives with RollJsonSupport {

  def apply(): Route =
    get {
      val r = 1 + (new Random(max + 1)).nextInt
      complete(Roll(dice = s"d${max}", result = r))
    }
}