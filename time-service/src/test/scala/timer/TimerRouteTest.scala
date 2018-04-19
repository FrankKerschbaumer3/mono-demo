package timer

import java.time.LocalDate

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

class TimerRouteTest extends FlatSpec with Matchers with ScalatestRouteTest with TimeJsonSupport {

  "Hello Route" should "return the Hello message" in {
    Get() ~> TimeRoute() ~> check {
      responseAs[Time].time shouldBe LocalDate.now().toString
    }
  }

}
