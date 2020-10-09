//package testing
//
//// https://shekhargulati.com/2017/09/14/finatra-tutorial-building-scalable-services-the-twitter-way/
//
//import com.twitter.finagle.http.Status._
//import com.twitter.finatra.http.EmbeddedHttpServer
//import com.twitter.inject.server.FeatureTest
//
////import org.scalatest.funsuite.AnyFunSuite
//
//// UDF
//import com.twitter.server.FitmanServer
//
//class HelloControllerFeatureTest extends FeatureTest {
//  override protected def server = new EmbeddedHttpServer(new FitmanServer)
//
//  test("Server#Say hello") {
//    server.httpGet(path = "/hello", andExpect = Ok, withBody = "FitmanApp Hello world !")
//  }
//}