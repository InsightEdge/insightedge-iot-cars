package com.magic;

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
public class CarEventCopyRemoveAfterReplicationListener {

    private static final Logger LOG = Logger.getLogger(CarEventCopyRemoveAfterReplicationListener.class.getName());

    @EventTemplate
    RemoveCarEventCopyEvent unprocessedData() {
        return new RemoveCarEventCopyEvent();
    }

    @SpaceDataEvent
    public CarEvent eventListener(RemoveCarEventCopyEvent event, GigaSpace gigaSpace) {
        gigaSpace.takeById(CarEventCopy.class, event.getCarEventCopyId());
        gigaSpace.clear(event);
        LOG.info("Replicated CarEventCopy was deleted: " + event.getCarEventCopyId());
        return null;
    }

}
