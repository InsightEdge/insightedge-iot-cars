package com.magic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
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
						httpPost(postUrl, e.toString());
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

		public static void httpPost(String postUrl, String payload) throws IOException {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(postUrl);

			HttpEntity entity = MultipartEntityBuilder
					.create()
					.addTextBody("appname", "IFSIoTDemo")
					.addTextBody("prgname", "HTTP")
					.addTextBody("arguments", "-AHTTP_IoTDemo#RobotTransmission,TransmissionXML")
					.addTextBody("TransmissionXML", payload)
					.build();

			httppost.setEntity(entity);

			HttpResponse response = httpclient.execute(httppost);
			System.out.println("HTTP response code = " + response.getStatusLine().getStatusCode());
			BufferedReader respReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line;
			while ((line = respReader.readLine()) != null) {
				System.out.println(line);
			}
		}
}
