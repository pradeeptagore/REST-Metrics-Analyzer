package com.rmat.restclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {
	public String getRestResponse(String url,String method) {
		String sresponse = "Failed to get output from Server .... \n";
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource(url);
			ClientResponse response = null;
			switch (method) {
			case "GET":
				response = webResource.accept("application/json")
				.get(ClientResponse.class);
				break;
			case "PUT":
				response = webResource.accept("application/json")
				.put(ClientResponse.class);
				break;
			case "POST":
				 response = webResource.accept("application/json")
				.post(ClientResponse.class);
				break;
			case "DELETE":
				 response = webResource.accept("application/json")
				.delete(ClientResponse.class);
				break;

			default:
				break;
			}
			
			if (response ==null || response.getStatus() != 200) {
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
