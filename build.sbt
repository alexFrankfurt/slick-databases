name := "slickwithpostgresql"

scalaVersion := "2.13.1"

resolvers ++= Seq(
 "Local Maven" at Path.userHome.asFile.toURI.toURL + ".m2/repository"
)

libraryDependencies ++= List(
    "com.typesafe.slick"    %%   "slick"        %     "3.3.2",
    "com.typesafe.slick"    %% "slick-hikaricp" % "3.3.2",
    "ch.qos.logback"         %  "logback-classic"  % "1.2.3",
    "org.slf4j"              %    "slf4j-api"   %     "1.7.25",
    "org.postgresql"         %  "postgresql"    %    "42.2.9",
    "com.oracle"             % "ojdbc7"         % "12.1.0.2"
)
