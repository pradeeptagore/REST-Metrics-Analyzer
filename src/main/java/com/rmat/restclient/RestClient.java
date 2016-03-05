package com.rmat.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	public String getRestResponse(String url) {
		String sresponse = "Output from Server .... \n";
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource(url);
			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			sresponse = response.getEntity(String.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sresponse;
	}	
}
