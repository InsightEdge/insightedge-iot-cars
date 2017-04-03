package com.magic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.magic.insightedge.model.CarEvent;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.UrlSpaceConfigurer;

import com.j_spaces.core.client.SQLQuery;
//import com.magic.insightedge.model.CarEvent;
//import com.magic.events.Events.CarEvent;

import play.api.libs.json.Json;


public class CarEventDispatcher {

		private static final String POST_URL = "http://52.168.165.238:1500/";
//	private static final String POST_URL = "http://localhost:8091/";


	public static void main(String [] args) throws InterruptedException {
			
					
			UrlSpaceConfigurer spaceConfigurer = new UrlSpaceConfigurer("jini://localhost/*/insightedge-space");
			GigaSpace gigaSpace = new GigaSpaceConfigurer(spaceConfigurer).gigaSpace();
				
			SQLQuery<CarEvent> query = new SQLQuery<CarEvent>(CarEvent.class, "isSentByHttp = false");

			CarEvent[] events = gigaSpace.takeMultiple(query);
			if(events.length > 0) {
				System.out.println("	Dispatching " + events.length + " car events from space ");
				for(CarEvent e : events) {
					System.out.println("Posting " + e);
					try {
						httpPost(e.toString());
						Thread.sleep(1000);
					} catch(IOException ex) {
						ex.printStackTrace();
					}
				}
			} else {
				System.out.println("	Nothing to dispatch, 0 events in space ");
			}
			
		}
		
		private static void httpPost(String payload) throws IOException {
			URL obj = new URL(POST_URL);
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
