package com.twitter.server

// https://twitter.github.io/finatra/user-guide/http/requests.html
// https://github.com/twitter/finatra/blob/6c02166790eeb2ae32f736c7e88da7418e8f58ff/http/src/test/scala/com/twitter/finatra/http/tests/integration/doeverything/main/controllers/DoEverythingController.scala
// https://github.com/twitter/finatra/blob/6c02166790eeb2ae32f736c7e88da7418e8f58ff/http/src/test/scala/com/twitter/finatra/http/tests/integration/doeverything/main/controllers/DoEverythingController.scala

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.{Controller, HttpServer}
import com.twitter.finatra.http.jsonpatch.JsonPatchOperator
import com.twitter.finatra.http.jsonpatch.{JsonPatchExceptionMapper, JsonPatchMessageBodyReader}
import com.twitter.finatra.http.jsonpatch.{JsonPatch, JsonPatchOperator, JsonPatchUtility}
import org.joda.time.Instant

import javax.inject.Inject

object FitmanAppJSONPatchRequests extends FitmanServer6

class FitmanServer6 extends HttpServer {
  override protected def defaultHttpsPort: String = ":8080"
  override protected def defaultHttpServerName: String = "FitMan"

  override protected def configureHttp(router: HttpRouter) {
    router.register[JsonPatchMessageBodyReader]
    router.exceptionMapper[JsonPatchExceptionMapper]
    router.add[HelloController6]
   //router.add[ExampleController]
  }
}

class HelloController6 extends Controller {
  get("/hello") {request: Request => "FitmanApp Hello world !"}
}

class MyController @Inject()( jsonPatchOperator: JsonPatchOperator
) extends Controller {
  patch("/jsonPatch") { jsonPatch: JsonPatch =>
    val testCase = ExampleCaseClass("world")
    val originalJson = jsonPatchOperator.toJsonNode[ExampleCaseClass](testCase)
    JsonPatchUtility.operate(jsonPatch.patches, jsonPatchOperator, originalJson)
  }
}

case class ExampleCaseClass(
    name: String
  )
