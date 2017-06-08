package com.github.reetawwsum.kap

import org.apache.avro.Schema
import org.apache.avro.generic.{GenericData, GenericRecord}
import org.apache.avro.generic.GenericData.Record

import com.twitter.bijection.Injection
import com.twitter.bijection.avro.GenericAvroCodecs

import org.apache.kafka.clients.producer.ProducerRecord

class AvroProducer {
  private val schema: Schema = Utils.getSchema(Config.schemaFilename)

  def publish(data: List[String]): Unit = {
    data.foreach { row =>
      val record = getGenericDataRecord(row)
      val bytes = getBinaryRecord(record)
      send(bytes)
    }
  }

  def getGenericDataRecord(row: String): Record = {
    val record = new GenericData.Record(schema)
    row.split(",").zipWithIndex.foreach {
      case (value, key) => record.put(key, value)
    }
    record
  }

  def getBinaryRecord(record: Record): Array[Byte] = {
    val recordInjection: Injection[GenericRecord, Array[Byte]] = GenericAvroCodecs.toBinary(schema)
    recordInjection.apply(record)
  }

  def send(bytes: Array[Byte]): Unit = {
    val producer = AvroKafkaProducer.getInstance
    val record = new ProducerRecord[String, Array[Byte]](Config.topicName, bytes)
    producer.send(record)
  }
}
