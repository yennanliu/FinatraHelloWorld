package utils

class SQLUtils {

  def getDataCount(table:String):Int = {
    val query = s"SELECT * FROM $table"
    print (query)
    val count = 123
    // TOFIX
    count
  }

  def queryDB(query:String):String = {
    print(query)
    val result = "this is dummy result"
    result
  }

}
