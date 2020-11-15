package dev

// UDF
import utils.SQLUtils

object SQLiteTestRunner extends App{
  println("SQLiteTestRunner run ...")
  val sql_utils = new SQLUtils
  sql_utils.showDBData()
  sql_utils.getDataCount()
}
