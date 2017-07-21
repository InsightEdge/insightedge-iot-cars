package com.magic;

import com.j_spaces.core.client.SQLQuery;
import com.magic.insightedge.model.CarEvent;
import com.magic.insightedge.model.CarEventDummy;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

public class CarEventDispatcher {

    public static void main(String[] args) throws InterruptedException {

        if (args.length < 5) {
            System.out.println("\tNot enough arguments. Usage: java -jar events-dispatcher.jar <space-name> <remove-dispatched-from-space true|false> <infinity true|false>");
            System.exit(1);
        }

        String space = args[0];
        System.out.println("\tSpace name: " + space);

        // remove dispatched from the space or update field 'isSentByHttp' to 'true'
        boolean removeDispatchedFromSpace = Boolean.parseBoolean(args[1]);
        System.out.println("\tRemove dispatched events from space: " + removeDispatchedFromSpace);

        boolean infinity = Boolean.parseBoolean(args[2]);
        System.out.println("\tIs infinity: " + removeDispatchedFromSpace);

        Integer sleep = Integer.parseInt(args[3]);
        System.out.println("\tSleep: " + sleep);

        Integer everyItemSleep = Integer.parseInt(args[4]);
        System.out.println("\tEvery Item Sleep: " + everyItemSleep);

        UrlSpaceConfigurer spaceConfigurer = new UrlSpaceConfigurer("jini://localhost/*/" + space);
        GigaSpace gigaSpace = new GigaSpaceConfigurer(spaceConfigurer).gigaSpace();

        SQLQuery<CarEvent> query = new SQLQuery<CarEvent>(CarEvent.class, "isSent = false");

        do {
            CarEvent[] events;
            if (removeDispatchedFromSpace) {
                events = gigaSpace.takeMultiple(query);
            } else {
                events = gigaSpace.readMultiple(query);
            }

            if (events.length == 0) {
                System.out.println("	Nothing to dispatch, 0 events in space ");
                Thread.sleep(sleep);
                continue;
            }

            System.out.println("	Dispatching " + events.length + " car events from space ");
            for (CarEvent event : events) {
                CarEventDummy dummyEvent = convertToDummy(event);
                System.out.println("Writing dummy: " + dummyEvent);
                gigaSpace.write(dummyEvent);
                Thread.sleep(everyItemSleep);
                if (!removeDispatchedFromSpace) {
                    event.setIsSent(true);
                    gigaSpace.write(event);
                }
            }
            Thread.sleep(sleep);
        } while (infinity);

    }

    private static CarEventDummy convertToDummy(CarEvent event) {
        return new CarEventDummy(event);
    }

}
