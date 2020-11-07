package com.yen.server

// app init SQLite database

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.{Controller, HttpServer}

import scala.concurrent.ExecutionContext.Implicits.global
import slick.driver.SQLiteDriver.api._

// UDF
import schema.SqlLiteSchema._

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

class DBRunner{
  val coffees = TableQuery[Coffees]

  val suppliers = TableQuery[Suppliers]

  val db = Database.forConfig("coffees")

  val setup = DBIO.seq(
    // Create the tables, including primary and foreign keys
    (suppliers.schema ++ coffees.schema).create,

    // Insert some suppliers
    suppliers += (101, "Acme, Inc.",      "99 Market Street", "Groundsville", "CA", "95199"),
    suppliers += ( 49, "Superior Coffee", "1 Party Place",    "Mendocino",    "CA", "95460"),
    suppliers += (150, "The High Ground", "100 Coffee Lane",  "Meadows",      "CA", "93966"),
    // Equivalent SQL code:
    // insert into SUPPLIERS(SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP) values (?,?,?,?,?,?)

    // Insert some coffees (using JDBC's batch insert feature, if supported by the DB)
    coffees ++= Seq(
      ("Colombian",         101, 7.99, 0, 0),
      ("French_Roast",       49, 8.99, 0, 0),
      ("Espresso",          150, 9.99, 0, 0),
      ("Colombian_Decaf",   101, 8.99, 0, 0),
      ("French_Roast_Decaf", 49, 9.99, 0, 0)
    )
    // Equivalent SQL code:
    // insert into COFFEES(COF_NAME, SUP_ID, PRICE, SALES, TOTAL) values (?,?,?,?,?)
  )

}
