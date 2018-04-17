package mono

import akka.http.scaladsl.testkit.ScalatestRouteTest
import mono.hello.{Hello, HelloJsonSupport, HelloRoute}
import org.scalatest.{FlatSpec, Matchers}

class HelloRouteTest extends FlatSpec with Matchers with ScalatestRouteTest with HelloJsonSupport {

  "Hello Route" should "return the Hello message" in {
    Get() ~> HelloRoute() ~> check {
      responseAs[Hello] shouldBe Hello("Hello World!")
    }
  }

}
