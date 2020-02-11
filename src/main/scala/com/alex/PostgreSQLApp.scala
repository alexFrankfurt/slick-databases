package com.alex

import slick.jdbc.PostgresProfile.api._


/** PostrgreSQL 10.11 */
object PostgreSQLApp extends App {

  val dbPG = Database.forConfig("postgresql")

  val dbPrefixLike = "${dbPrefix}%"
  import scala.concurrent.Await
  import scala.concurrent.duration._

  val oldDbsAction: DBIO[Vector[String]] =
    sql"SELECT datname FROM pg_database WHERE datname like '#${dbPrefixLike}'".as[String]

  println("hello from app")
  Await.result(dbPG.run(oldDbsAction), Duration.Inf)

  // comment out to not connect to specific databases
  println(OracleApp)

}
