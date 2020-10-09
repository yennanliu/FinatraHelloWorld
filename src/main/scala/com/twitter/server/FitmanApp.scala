package com.twitter.server

// https://shekhargulati.com/2017/09/14/finatra-tutorial-building-scalable-services-the-twitter-way/
// test the API via :
// curl localhost:8888/hello

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.{Controller, HttpServer}

object FitmanApp extends  FitmanServer

class FitmanServer extends  HttpServer {
  override protected def configureHttp(router: HttpRouter) {
      router.add[HelloController]
  }
}

class HelloController extends  Controller {
  get("/hello") {request: Request => "FitmanApp Hello world !"}
}
