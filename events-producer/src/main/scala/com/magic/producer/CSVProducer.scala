package com.magic.producer

import scala.io
import scala.util.Random
import java.util.{Properties, UUID}
import com.magic.events.Events._
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import play.api.libs.json.Json

/**
  * Created by tal on 3/15/17.
  */
object CSVProducer {

  def run(kafkaConfig: Properties): Unit = {
    println("-- Running CSV producer")
    println("------- first arg:" + kafkaConfig.getProperty(CSV_LOCATION))
    val bufferedSource = io.Source.fromFile(kafkaConfig.getProperty(CSV_LOCATION))

    val producer = new KafkaProducer[String, String](kafkaConfig)
    val topic = kafkaConfig.getProperty(TOPIC_CAR)

    Thread.sleep(1000) //add two more zeros to wait a whole second

    //drop the headers first line
    for (line <- bufferedSource.getLines.drop(1)) {
      val cols = line.split(",").map(_.trim)
      // do whatever you want with the columns here
      val eventJson = Json.toJson(CarEvent(
        cols(0).toInt,
        cols(1),
        cols(2),
        cols(3),
        cols(4),
        cols(5).toInt,
        cols(6),
        cols(7),
        cols(8),
        cols(9),
        cols(10),
        cols(11).toDouble,
        cols(12).toDouble,
        cols(13).toDouble,
        cols(14).toDouble,
        cols(15),
        cols(16).toDouble,
        cols(17),
        cols(18).toDouble,
        cols(19).toDouble,
        false)).toString()

      println(s"sending event to $topic $eventJson")
      producer.send(new ProducerRecord[String, String](topic, eventJson))
      producer.flush()
      println(s"JSON is: $eventJson")

    }
    bufferedSource.close
    Thread.sleep(1000) //add two more zeros to wait a whole second

  }


}
