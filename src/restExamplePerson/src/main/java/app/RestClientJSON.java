package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

public class RestClientJSON {
	
	public static void main(String[] args) {
		
		try {

			// Create http client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create request
			HttpGet getRequest = new HttpGet("http://localhost:8080/restExample/rest/person/getAll");
			

			// Add additonall headers parameters
			getRequest.addHeader("accept", "application/json");

			// Execute request
			HttpResponse response = httpClient.execute(getRequest);

			// Http response code
			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String output;
			

			System.out.println("Response :");

			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}


		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
