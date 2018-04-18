package mono

import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

class HelloRouteTest extends FlatSpec with Matchers with ScalatestRouteTest with HelloJsonSupport {

  "Hello Route" should "return the Hello message" in {
    Get() ~> HelloRoute() ~> check {
      responseAs[Hello] shouldBe Hello("Hello Demo World!")
    }
  }

}
