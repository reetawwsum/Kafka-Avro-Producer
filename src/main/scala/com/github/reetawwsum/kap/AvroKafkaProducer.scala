package com.github.reetawwsum.kap

import org.apache.kafka.clients.producer.KafkaProducer

object AvroKafkaProducer {
  def getInstance(): KafkaProducer[String, Array[Byte]] = new KafkaProducer[String, Array[Byte]](Config.props)
}
