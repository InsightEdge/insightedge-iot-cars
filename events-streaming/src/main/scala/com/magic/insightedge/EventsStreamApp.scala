package com.magic.insightedge

import com.magic.events.Events
import com.magic.events.Events.CarEvent
import kafka.serializer.StringDecoder
import org.apache.log4j.{Level, Logger}
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.SparkConf
import org.insightedge.spark.context.InsightEdgeConfig
import org.insightedge.spark.implicits.all._
import org.rogach.scallop.ScallopConf
import play.api.libs.json.Json


object EventsStreamApp {

  implicit val locationReads = Json.reads[Events.Location]
  implicit val carEventReads = Json.reads[CarEvent]

  def main(args : Array[String]): Unit = {
    println("Starting Car Events Stream")
    println(s"with params: ${args.toList}")

    val conf = new Conf(args)

    println(s"conf=${conf}")

    println(s"checkpointDir=${conf.checkpointDir()}")

    val ssc = StreamingContext.getOrCreate(conf.checkpointDir(), () => createContext(conf))

    ssc.start()
    ssc.awaitTermination()
    println("done")
  }

  class Conf(args: Array[String]) extends ScallopConf(args) {
    val masterUrl = opt[String]("master-url", required = true)
    val spaceName = opt[String]("space-name", required = true)
    val lookupGroups = opt[String]("lookup-groups", required = true)
    val lookupLocators = opt[String]("lookup-locators", required = true)
    val zookeeper = opt[String]("zookeeper", required = true)
    val groupId = opt[String]("group-id", required = true)
    val batchDuration = opt[String]("batch-duration", required = true)
    val checkpointDir = opt[String]("checkpoint-dir", required = true)
    verify()
  }

  def createContext(conf: Conf): StreamingContext = {
    val ieConfig = InsightEdgeConfig(conf.spaceName(), Some(conf.lookupGroups()), Some(conf.lookupLocators()))
    val scConfig = new SparkConf().setAppName("EventsStream").setMaster(conf.masterUrl()).setInsightEdgeConfig(ieConfig)
    val kafkaParams = Map("zookeeper.connect" -> conf.zookeeper(), "group.id" -> conf.groupId())
    val ssc = new StreamingContext(scConfig, Seconds(conf.batchDuration().toInt))
    ssc.checkpoint(conf.checkpointDir())
    val sc = ssc.sparkContext

    val rootLogger = Logger.getRootLogger
    rootLogger.setLevel(Level.ERROR)

    // open Kafka streams
    val carStream = createCarStream(ssc, kafkaParams)

    carStream
      .mapPartitions { partitions =>
       partitions.map { e =>
         print("mapping to scala CarEvent - " +e)
        model.CarEvent(
          e.ID,
          e.RECHNERBEZ,
          e.DCELINK_ID,
          e.SCHWEISSGERAETE_NAME,
          e.ORTSNUMMER,
          e.WIP,
          e.BOLZEN_ID,
          e.KAROSSERIE_ID,
          e.AUSGANGS_ID,
          e.SCHWEISSPROGRAMM_ID,
          e.SCHWEISSSTROM_IST,
          e.SCHWEISSZEIT_IST,
          e.UL_HAUPTSTROM_IST,
          e.UL_VORSTROM_IST,
          e.HUBHOEHE_IST,
          e.HUBHOEHE_SOLL,
          e.ABFALLZEIT_IST,
          e.ABFALLZEIT_SOLL,
          e.DURCHDRINGUNG_IST,
          e.SCHWEISSENERGIE_IST,
          e.IsSentByHttp)

       }
      }
      .saveToGrid()

    carStream
      .mapPartitions { partitions =>
       partitions.map { e =>
         println("mapping to Event1 - " +e)
         new Event1().setId(e.ID)
       }
      }
      .saveToGrid()

    carStream
      .mapPartitions { partitions =>
        partitions.map { e =>
          println("mapping to Event2 - " +e)
          new Event2().setId(e.ID)
        }
      }
      .saveToGrid()

    ssc
  }

  def createCarStream(ssc: StreamingContext, kafkaParams: Map[String, String]): DStream[CarEvent] = {
    KafkaUtils.createStream[String, String, StringDecoder, StringDecoder](ssc, kafkaParams,
      Map("car_events" -> 1), StorageLevel.MEMORY_ONLY)
      .map(_._2)
      .map(message => Json.parse(message).as[CarEvent])
  }
}
