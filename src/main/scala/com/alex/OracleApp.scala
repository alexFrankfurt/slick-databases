package com.alex

import slick.basic.DatabaseConfig
import slick.jdbc.OracleProfile

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

/** Oracle 18c XE
 */
object OracleApp extends OracleProfile.API {



  val dbOracle: Try[DatabaseConfig[OracleProfile]] = Try(DatabaseConfig.forConfig("oracle"))
//  lazy val dataSource: HikariDataSource = dbOracle.db.source.asInstanceOf[HikariCPJdbcDataSource].ds


  dbOracle match {
    case Failure(exception) => println(exception)
    case Success(dbOracle) =>
      val oldDbsAction: DBIO[Vector[(Int)]] =
        sql"SELECT * FROM TBL".as[(Int)]

      println("hello from app")
      val kk = Await.result(dbOracle.db.run(oldDbsAction), Duration.Inf)
      println(s"kk: $kk")
  }


}
