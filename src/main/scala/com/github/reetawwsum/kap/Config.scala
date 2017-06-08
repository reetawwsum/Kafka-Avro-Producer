package com.github.reetawwsum.kap

import java.util.Properties

object Config {
  val topicName: String = "myTopic"
  val dataFilename: String = "/data.csv"
  val schemaFilename: String = "/schema.avsc"
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer")
}
