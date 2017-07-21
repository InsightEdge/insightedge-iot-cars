package com.magic;

import com.j_spaces.core.client.SQLQuery;
import com.magic.insightedge.model.CarEvent;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

/**
 * @author Oleksiy_Dyagilev
 */
public class DeleteCarEventsUtil {
    public static void main(String[] args) {
        System.out.println("DELETING all CarEvent's from the space");

        UrlSpaceConfigurer spaceConfigurer = new UrlSpaceConfigurer("jini://localhost/*/insightedge-space");
        GigaSpace gigaSpace = new GigaSpaceConfigurer(spaceConfigurer).gigaSpace();

        SQLQuery<CarEvent> query = new SQLQuery<CarEvent>(CarEvent.class, "");
        gigaSpace.takeMultiple(query);

    }
}
