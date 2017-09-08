package com.magic.insightedge.model

import com.magic.insightedge.model
import org.openspaces.core.GigaSpaceConfigurer
import org.openspaces.core.space.UrlSpaceConfigurer

/**
  * @author Vitalii Zinchenko
  */
object Main {
  def main(args: Array[String]): Unit = {
    val space = createSpace
    val event = model.CarEvent(1,"test","test","test","test",2,"test","test","test","test","test",3.3,4.4,5.5,6.6,"test",7.7,"test",8.8,9.9,true)
    space.write(event)
    space.write(new model.CarEventDummy(event))

  }

  private def createSpace = {
    val configurer = new UrlSpaceConfigurer("jini://127.0.0.1/*/insightedge-space")
    configurer.lookupGroups("MASTER")
    new GigaSpaceConfigurer(configurer).gigaSpace
  }
}
