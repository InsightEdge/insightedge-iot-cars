package com.magic;

import com.j_spaces.core.client.SQLQuery;
import com.magic.insightedge.model.CarEvent;
import com.magic.insightedge.model.CarEventCopy;
import org.openspaces.core.GigaSpace;
import org.openspaces.events.EventDriven;
import org.openspaces.events.EventTemplate;
import org.openspaces.events.adapter.SpaceDataEvent;
import org.openspaces.events.notify.Notify;

import java.util.logging.Logger;

/**
 * @author Vitalii Zinchenko
 */
@EventDriven
@Notify
public class CarEventListener {

    private static final Logger LOG = Logger.getLogger(CarEventCopyRemoveAfterReplicationListener.class.getName());

    @EventTemplate
    SQLQuery<CarEvent> unprocessedData() {
        return new SQLQuery<CarEvent>(CarEvent.class, "isSentByHttp = false AND WIP = 0");
    }

    @SpaceDataEvent
    public CarEvent eventListener(CarEvent event, GigaSpace gigaSpace) {
        CarEventCopy eventCopy = new CarEventCopy();

        eventCopy.setID(event.ID());
        eventCopy.setRECHNERBEZ(event.RECHNERBEZ());
        eventCopy.setDCELINK_ID(event.DCELINK_ID());
        eventCopy.setSCHWEISSGERAETE_NAME(event.SCHWEISSGERAETE_NAME());
        eventCopy.setORTSNUMMER(event.ORTSNUMMER());
        eventCopy.setWIP(event.WIP());
        eventCopy.setBOLZEN_ID(event.BOLZEN_ID());
        eventCopy.setKAROSSERIE_ID(event.KAROSSERIE_ID());
        eventCopy.setAUSGANGS_ID(event.AUSGANGS_ID());
        eventCopy.setSCHWEISSPROGRAMM_ID(event.SCHWEISSPROGRAMM_ID());
        eventCopy.setSCHWEISSSTROM_IST(event.SCHWEISSSTROM_IST());
        eventCopy.setSCHWEISSZEIT_IST(event.SCHWEISSZEIT_IST());
        eventCopy.setUL_HAUPTSTROM_IST(event.UL_HAUPTSTROM_IST());
        eventCopy.setUL_VORSTROM_IST(event.UL_VORSTROM_IST());
        eventCopy.setHUBHOEHE_IST(event.HUBHOEHE_IST());
        eventCopy.setHUBHOEHE_SOLL(event.HUBHOEHE_SOLL());
        eventCopy.setABFALLZEIT_IST(event.ABFALLZEIT_IST());
        eventCopy.setABFALLZEIT_SOLL(event.ABFALLZEIT_SOLL());
        eventCopy.setDURCHDRINGUNG_IST(event.DURCHDRINGUNG_IST());
        eventCopy.setSCHWEISSENERGIE_IST(event.SCHWEISSENERGIE_IST());

        gigaSpace.write(eventCopy);

        LOG.info("CarEventCopy object was created with ID: " + eventCopy.getID());

        return null;
    }

}
