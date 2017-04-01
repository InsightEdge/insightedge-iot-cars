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

		private static final String POST_URL = "http://52.168.165.238:1500/";
			
		public static void main(String [] args) {
			System.out.println("Dispatching car events from Space");
					
			UrlSpaceConfigurer spaceConfigurer = new UrlSpaceConfigurer("jini://localhost/*/insightedge-space");
			GigaSpace gigaSpace = new GigaSpaceConfigurer(spaceConfigurer).gigaSpace();
				
			SQLQuery<CarEvent> query = new SQLQuery<CarEvent>(CarEvent.class, "isSentByHttp = false");

			for(CarEvent e : gigaSpace.readMultiple(query)) {
				System.out.println("Posting " + e);
				try {
					httpPost(e.toString());
				} catch(IOException ex) {
					ex.printStackTrace();
				}
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
