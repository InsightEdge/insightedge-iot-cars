package com.magic.insightedge.model

import java.util
import java.util.Date

import org.insightedge.scala.annotation.SpaceId
import play.api.libs.json._
import play.api.libs.json.{Json, Writes}

import scala.beans.BeanProperty

import org.insightedge.scala.annotation._
import scala.beans.{BeanProperty, BooleanBeanProperty}


/**
  * @author kobi on 13/02/17.
  * @since 12.1
  */
abstract class MagicEvent(ID: Int) {
  def this() = this(-1)
}

case class CarEvent(
                     @BeanProperty
                     @SpaceId
                     var ID: Int,

                     @BeanProperty
                     var RECHNERBEZ: String,

                     @BeanProperty
                     var DCELINK_ID: String,//3

                     @BeanProperty
                     var SCHWEISSGERAETE_NAME: String,//5

                     @BeanProperty
                     var ORTSNUMMER: String,//6

                     @BeanProperty
                     var WIP: Int, //] [bit] NOT NULL,//7

                     @BeanProperty
                     var BOLZEN_ID: String,

                     @BeanProperty
                     var KAROSSERIE_ID: String,

                     @BeanProperty
                     var AUSGANGS_ID: String,

                     @BeanProperty
                     var SCHWEISSPROGRAMM_ID: String,

                     @BeanProperty
                     var SCHWEISSSTROM_IST: String,

                     @BeanProperty
                     var SCHWEISSZEIT_IST: Double,

                     @BeanProperty
                     var UL_HAUPTSTROM_IST: Double,

                     @BeanProperty
                     var UL_VORSTROM_IST: Double,

                     @BeanProperty
                     var HUBHOEHE_IST: Double,

                     @BeanProperty
                     var HUBHOEHE_SOLL: String,

                     @BeanProperty
                     var ABFALLZEIT_IST: Double,

                     @BeanProperty
                     var ABFALLZEIT_SOLL: String,

                     @BeanProperty
                     var DURCHDRINGUNG_IST: Double,

                     @BeanProperty
                     var SCHWEISSENERGIE_IST: Double,

                     @BooleanBeanProperty
                     var IsSentByHttp: Boolean

                          ) extends MagicEvent() {
  def this() = this(
    -1,
    null,
    null,
    null,
    null,
    0,
    null,
    null,
    null,
    null,
    null,
    -1.0,
    -1.0,
    -1.0,
    -1.0,
    null,
    -1.0,
    null,
    -1.0,
    -1.0,
    false)

//  implicit val CarEventWrites = new Writes[CarEvent] {
//    def writes(carEvent: CarEvent) = Json.obj(
//      "ID" -> carEvent.ID,
//      "RECHNERBEZ" -> carEvent.RECHNERBEZ,
//      "IsSentByHttp" -> carEvent.IsSentByHttp
//    )
//  }
}

case class AggregatedCar(
                     @BeanProperty
                     @SpaceId
                     var aggregationId: String,

                     @BeanProperty
                     var date: Date,

                     @BeanProperty
                     var modelIdAgg: util.HashMap[Int, Long]
                   )  {
  def this() = this(null, null, null)
}

//case class CarEvent(
//var ID: Long,//1
//var RECHNERBEZ: String,//2
//var DCELINK_ID: String,//3
//var DATE_TIME: String,//4
//var SCHWEISSGERAETE_NAME: String,//5
//var ORTSNUMMER: String,//6
//var WIP: Int, //] [bit] NOT NULL,//7
//var ANZAHL_WIPWOP_PROG: String,//8
//var ANZAHL_WOP_PROG: String,
//var BOLZEN_ID: String,
//var KAROSSERIE_ID: String,
//var AUSGANGS_ID: String,
//var SCHWEISSPROGRAMM_ID: String,
//var SCHWEISSSTROM_IST: String,
//var SCHWEISSSTROM_SOLL: String,
//var SCHWEISSSTROM_TP: String,
//var SCHWEISSSTROM_TM: String,
//var SCHWEISSZEIT_IST: Long,
//var SCHWEISSZEIT_SOLL: String,
//var SCHWEISSZEIT_TP: String,
//var SCHWEISSZEIT_TM: String,
//var UL_HAUPTSTROM_IST: Long,
//var UL_HAUPTSTROM_SOLL: String,
//var UL_HAUPTSTROM_TP: String,
//var UL_HAUPTSTROM_TM: String,
//var UL_VORSTROM_IST: Long,
//var UL_VORSTROM_SOLL: String,
//var UL_VORSTROM_TP: String,
//var UL_VORSTROM_TM: String,
//var HUBHOEHE_GUELTIG: String,
//var HUBHOEHE_IST: Long,
//var HUBHOEHE_SOLL: String,
//var HUBHOEHE_TP: String,
//var HUBHOEHE_TM: String,
//var ABFALLZEIT_IST: Long,
//var ABFALLZEIT_SOLL: String,
//var DURCHDRINGUNG_GUELTIG: String,
//var DURCHDRINGUNG_IST: Long,
//var DURCHDRINGUNG_SOLL: String,
//var DURCHDRINGUNG_TP: String,
//var DURCHDRINGUNG_TM: String,
//var SCHWEISSENERGIE_IST: Long,
//var SCHWEISSENERGIE_SOLL: String,
//var SCHWEISSENERGIE_TP: String,
//var SCHWEISSENERGIE_TM: String,
//var SCHWEISSSTROM2_IST: String,
//var SCHWEISSSTROM2_SOLL: String,
//var SCHWEISSSTROM3_IST: String,
//var SCHWEISSSTROM3_SOLL: String,
//var UL_HAUPTSTROM2_IST: String,
//var UL_HAUPTSTROM3_IST: String,
//var SCHWEISSZEIT2_IST: String,
//var SCHWEISSZEIT3_IST: String,
//var SPANNUNGSSPITZE_IST: String,
//var SPANNUNGSEINBRUCH_IST: String,
//var BOLZENUEBERSTAND_GUELTIG: String,
//var BOLZENUEBERSTAND_IST: String,
//var DISTANZNULLLINIE_GUELTIG: String,
//var DISTANZNULLLINIE_IST: String,
//var LMR_WINKEL_GUELTIG: String,
//var LMR_WINKEL_IST: String,
//var PROCESSDATA_INTERFACE_ID: String,
//var ADDITIONAL01: String,
//var ADDITIONAL02: String,
//var ADDITIONAL03: String,
//var ADDITIONAL04: String,
//var ADDITIONAL05: String,
//var PRODSERIES_COMBINATION_ID: String
//
//                          ) extends MagicEvent(ID)
//
//{
//  def this() = this(
//    -1,
//    null,
//    null,
//    null,
//    null,
//    null,
//    0,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    -1,
//    null,
//    null,
//    null,
//    -1,
//    null,
//    null,
//    null,
//    -1,
//    null,
//    null,
//    null,
//    null,
//    -1,
//    null,
//    null,
//    null,
//    -1,
//    null,
//    null,
//    -1,
//    null,
//    null,
//    null,
//    -1,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null,
//    null
//  )
//}
