package com.magic.events

import java.io.Serializable

import play.api.libs.json.{Json, Writes}

/**
  * @author kobi on 13/02/17.
  * @since 12.1
  */
object Events {

  case class Location(locationId: Int, state: String, city: String, latitude: String, longitude: String)



  case class CarEvent(ID: Int,
                      RECHNERBEZ: String,
                      DCELINK_ID: String,
                      SCHWEISSGERAETE_NAME: String,
                      ORTSNUMMER: String,
                      WIP: Int,
                      BOLZEN_ID: String,
                      KAROSSERIE_ID: String,
                      AUSGANGS_ID: String,
                      SCHWEISSPROGRAMM_ID: String,
                      SCHWEISSSTROM_IST: String,
                      SCHWEISSZEIT_IST: Double,
                      UL_HAUPTSTROM_IST: Double,
                      UL_VORSTROM_IST: Double,
                      HUBHOEHE_IST: Double,
                      HUBHOEHE_SOLL: String,
                      ABFALLZEIT_IST: Double,
                      ABFALLZEIT_SOLL: String,
                      DURCHDRINGUNG_IST: Double,
                      SCHWEISSENERGIE_IST: Double,
                      IsSentByHttp: Boolean)


  implicit val CarEventWrites = new Writes[CarEvent] {
    def writes(carEvent: CarEvent) = Json.obj(
      "ID" -> carEvent.ID,
      "RECHNERBEZ" -> carEvent.RECHNERBEZ,
      "DCELINK_ID" -> carEvent.DCELINK_ID,
      "SCHWEISSGERAETE_NAME" -> carEvent.SCHWEISSGERAETE_NAME,
      "ORTSNUMMER" -> carEvent.ORTSNUMMER,
      "WIP" -> carEvent.WIP,
      "BOLZEN_ID" -> carEvent.BOLZEN_ID,
      "KAROSSERIE_ID" -> carEvent.KAROSSERIE_ID,
      "AUSGANGS_ID" -> carEvent.AUSGANGS_ID,
      "SCHWEISSPROGRAMM_ID" -> carEvent.SCHWEISSPROGRAMM_ID,
      "SCHWEISSSTROM_IST" -> carEvent.SCHWEISSSTROM_IST,
      "SCHWEISSZEIT_IST" -> carEvent.SCHWEISSZEIT_IST,
      "UL_HAUPTSTROM_IST" -> carEvent.UL_HAUPTSTROM_IST,
      "UL_VORSTROM_IST" -> carEvent.UL_VORSTROM_IST,
      "HUBHOEHE_IST" -> carEvent.HUBHOEHE_IST,
      "HUBHOEHE_SOLL" -> carEvent.HUBHOEHE_SOLL,
      "ABFALLZEIT_IST" -> carEvent.ABFALLZEIT_IST,
      "ABFALLZEIT_SOLL" -> carEvent.ABFALLZEIT_SOLL,
      "DURCHDRINGUNG_IST" -> carEvent.DURCHDRINGUNG_IST,
      "SCHWEISSENERGIE_IST" -> carEvent.SCHWEISSENERGIE_IST,
      "IsSentByHttp" -> carEvent.IsSentByHttp
    )
  }

}

//  case class CarEvent(eventId: Long, carId: Int, modelId: Int, location: Location)
