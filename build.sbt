name := "Kafka-Avro-Producer"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.apache.avro" % "avro" % "1.7.7",
  "com.twitter" %% "bijection-core" % "0.9.5",
  "com.twitter" % "bijection-avro_2.11" % "0.9.5",
  "org.apache.kafka" % "kafka-clients" % "0.10.2.0"
)
