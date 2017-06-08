package com.github.reetawwsum.kap

import org.apache.avro.Schema

object Utils {
  def getDataFromFile(filename: String): List[String] = {
    val stream = getClass.getResourceAsStream(filename)
    scala.io.Source.fromInputStream(stream).getLines.toList
  }

  def getSchema(schemaFilename: String): Schema = {
    val stream = getClass.getResourceAsStream(schemaFilename)
    val schemaString = scala.io.Source.fromInputStream(stream).getLines.mkString
    new Schema.Parser().parse(schemaString)
  }
}
