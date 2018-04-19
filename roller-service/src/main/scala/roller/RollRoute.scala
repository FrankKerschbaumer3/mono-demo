package roller

import akka.http.scaladsl.server.Route
import roller.Main.{complete, get}

import scala.util.Random

case class Roll(dice: String, result: Int)

trait RollJsonSupport extends JsonSupport {
  implicit val rollFormat = jsonFormat2(Roll)
}

object RollRoute extends RollJsonSupport {
  def apply(max: Int): Route =
      get {
        val r = 1 + new Random().nextInt(max)
        complete(Roll(dice = s"d${max}", result = r))
      }
}