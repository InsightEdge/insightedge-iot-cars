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
                     var DCELINK_ID: String, //3

                     @BeanProperty
                     var SCHWEISSGERAETE_NAME: String, //5

                     @BeanProperty
                     var ORTSNUMMER: String, //6

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
                     var IsSent: Boolean) extends MagicEvent() {
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
}

case class CarEventDummy(
                          @BeanProperty
                          @SpaceId
                          var ID: Int,

                          @BeanProperty
                          var RECHNERBEZ: String,

                          @BeanProperty
                          var DCELINK_ID: String, //3

                          @BeanProperty
                          var SCHWEISSGERAETE_NAME: String, //5

                          @BeanProperty
                          var ORTSNUMMER: String, //6

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
                          var SCHWEISSENERGIE_IST: Double) extends MagicEvent() {
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
    -1.0)

  def this(event: CarEvent) = {
    this(
      event.ID,
      event.RECHNERBEZ,
      event.DCELINK_ID,
      event.SCHWEISSGERAETE_NAME,
      event.ORTSNUMMER,
      event.WIP,
      event.BOLZEN_ID,
      event.KAROSSERIE_ID,
      event.AUSGANGS_ID,
      event.SCHWEISSPROGRAMM_ID,
      event.SCHWEISSSTROM_IST,
      event.SCHWEISSZEIT_IST,
      event.UL_HAUPTSTROM_IST,
      event.UL_VORSTROM_IST,
      event.HUBHOEHE_IST,
      event.HUBHOEHE_SOLL,
      event.ABFALLZEIT_IST,
      event.ABFALLZEIT_SOLL,
      event.DURCHDRINGUNG_IST,
      event.SCHWEISSENERGIE_IST)
  }
}


case class AggregatedCar(
                          @BeanProperty
                          @SpaceId
                          var aggregationId: String,

                          @BeanProperty
                          var date: Date,

                          @BeanProperty
                          var modelIdAgg: util.HashMap[Int, Long]
                        ) {
  def this() = this(null, null, null)
}
