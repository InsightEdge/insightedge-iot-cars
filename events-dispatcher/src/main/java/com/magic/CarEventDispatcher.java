package com.magic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import com.j_spaces.core.client.SQLQuery;
import com.magic.insightedge.model.CarEvent;

public class CarEventDispatcher {

        private static String postUrl;

		public static void main(String[] args) throws InterruptedException {

			if (args.length < 2) {
                System.out.println("\tNot enough arguments. Usage: java -jar events-dispatcher.jar <post-url> <remove-dispatched-from-space true|false>");
                System.exit(1);
            }

            postUrl = args[0];
            System.out.println("\tPOST URL: " + postUrl);

			// remove dispatched from the space or update field 'isSentByHttp' to 'true'
			boolean removeDispatchedFromSpace = Boolean.parseBoolean(args[1]);
			System.out.println("\tRemove dispatched events from space: " + removeDispatchedFromSpace);

            UrlSpaceConfigurer spaceConfigurer = new UrlSpaceConfigurer("jini://localhost/*/insightedge-space");
			GigaSpace gigaSpace = new GigaSpaceConfigurer(spaceConfigurer).gigaSpace();

			SQLQuery<CarEvent> query = new SQLQuery<CarEvent>(CarEvent.class, "isSentByHttp = false AND WIP = 0");

			CarEvent[] events;
			if (removeDispatchedFromSpace) {
				events = gigaSpace.takeMultiple(query);
			} else {
				events = gigaSpace.readMultiple(query);
			}

			if(events.length > 0) {
				System.out.println("	Dispatching " + events.length + " car events from space ");
				for(CarEvent e : events) {
					System.out.println("Posting " + e);
					try {
						httpPost(e.toString());
						Thread.sleep(1000);
					} catch(IOException ex) {
						ex.printStackTrace();
					} finally {
                        if (!removeDispatchedFromSpace) {
                            e.setIsSentByHttp(true);
                            gigaSpace.write(e);
                        }
                    }
				}
			} else {
				System.out.println("	Nothing to dispatch, 0 events in space ");
			}

		}

		private static void httpPost(String payload) throws IOException {
			URL obj = new URL(postUrl);
			  HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			  // Setting basic post request
			  con.setRequestMethod("POST");
			  con.setRequestProperty("Content-Type","application/json");

			  // Send post request
			  con.setDoOutput(true);
			  DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			  wr.writeBytes(payload);
			  wr.flush();
			  wr.close();

			  // Get response
			  BufferedReader in = new BufferedReader(
			          new InputStreamReader(con.getInputStream()));
			  String output;
			  StringBuffer response = new StringBuffer();

			  while ((output = in.readLine()) != null) {
			   response.append(output);
			  }
			  in.close();

			  //printing result from response
			  System.out.println(response.toString());
		}
}
