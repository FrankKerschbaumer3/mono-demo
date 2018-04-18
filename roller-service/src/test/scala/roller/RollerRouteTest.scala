package roller

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

class RollerRouteTest extends FlatSpec with Matchers with ScalatestRouteTest with RollJsonSupport {

  "Roller Route" should "return 1 for a d1 roll" in {
    Get() ~> RollRoute(1) ~> check {
      responseAs[Roll] shouldBe Roll(dice="d1", result=1)
    }
  }

  "Roller Route" should "return a number within range" in {
    Get() ~> RollRoute(20) ~> check {
      responseAs[Roll].result should be >= 1
      responseAs[Roll].result should be <= 20
    }
  }
}