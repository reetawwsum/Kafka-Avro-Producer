package com.github.reetawwsum.kap

object Main extends App {
  val data = Utils.getDataFromFile(Config.dataFilename)
  val avroProducer = new AvroProducer()
  avroProducer.publish(data)
  println(s"Data published in topic")
}
