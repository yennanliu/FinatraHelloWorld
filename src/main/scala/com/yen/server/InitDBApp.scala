package com.yen.server

// app init SQLite database

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.{Controller, HttpServer}

import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.SQLiteDriver.api._

// UDF
import schema.SqlLiteSchema._
import services.SQLiteRunner.DBRunner

object InitDBApp extends DBServer

class DBServer extends HttpServer {
  override protected def defaultHttpsPort: String = ":8080"

  override protected def configureHttp(router: HttpRouter) {
    router.add[HelloController]
    router.add[DBController]
  }
}

class HelloController extends  Controller {
  get("/hello") {request: Request => "FitmanApp Hello world !"}
}

class DBController extends  Controller {
  val db_runner = new DBRunner
  val setupFuture = db_runner.db.run(db_runner.setup)
  get("/db_init") {request: Request => "init SQLITE DB!"}
}

