package com.magic;

import com.j_spaces.core.client.SQLQuery;
import com.magic.insightedge.model.CarEvent;
import com.magic.insightedge.model.CarEventDummy;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

public class CarEventDispatcherTest {

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

        gigaSpace.write(new CarEvent(333,"M050UB92BRT2","459543","15 UB92 130SWB221","8814",1,"22620019","17446774","1","16","750",30.20000076,24.60000038,22.79999924,1.50999999,"1.5",9.199999809,"9",-0.66900003,566, false));
//        gigaSpace.write(new CarEventDummy(112,"M050UB92BRT2","459543","15 UB92 130SWB221","8814",1,"22620019","17446774","1","16","750",30.20000076,24.60000038,22.79999924,1.50999999,"1.5",9.199999809,"9",-0.66900003,566));


//        do {
//            CarEvent[] events;
//            if (removeDispatchedFromSpace) {
//                events = gigaSpace.takeMultiple(query);
//            } else {
//                events = gigaSpace.readMultiple(query);
//            }
//
//            if (events.length == 0) {
//                System.out.println("	Nothing to dispatch, 0 events in space ");
//                return;
//            }
//
//            System.out.println("	Dispatching " + events.length + " car events from space ");
//            for (CarEvent event : events) {
//                CarEventDummy dummyEvent = convertToDummy(event);
//                System.out.println("Writing dummy: " + dummyEvent);
//                gigaSpace.write(dummyEvent);
//                Thread.sleep(everyItemSleep);
//                if (!removeDispatchedFromSpace) {
//                    event.setIsSent(true);
//                    gigaSpace.write(event);
//                }
//            }
//            Thread.sleep(sleep);
//        } while (infinity);

    }

    private static CarEventDummy convertToDummy(CarEvent event) {
        return new CarEventDummy(event);
    }

}
