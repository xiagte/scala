package util

import java.sql.{Connection, Statement}

case class ConnectSQL(driver: String, url: String, userName: String, password: String)

class H2database extends LoggerSupport {
  var conn: Connection = null
  var stmt: Statement = null



}
