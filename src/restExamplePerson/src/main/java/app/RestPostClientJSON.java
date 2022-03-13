package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;


public class RestPostClientJSON {

	public static void main(String[] args) {

		try {

			HttpClient client = HttpClientBuilder.create().build();

			HttpPost postRequest = new HttpPost("http://localhost:8080/restExample/rest/person/create");

			postRequest.addHeader("Accept", "*/*");
			
			
//			List<NameValuePair> params = new ArrayList<NameValuePair>();
//			
//			params.add(new BasicNameValuePair("id", "10"));
//			params.add(new BasicNameValuePair("firstName", "Dimitar"));
//			params.add(new BasicNameValuePair("lastName", "Josifov"));
//			params.add(new BasicNameValuePair("email", "jdimitar@gmial.com"));
			
//			postRequest.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
//			
//			Person p = new Person(11, "Dimitar", "Josifov", "bla@gmail.com");
			
			StringEntity params = new StringEntity("{\r\n"
					+ "    \"id\": 9,\r\n"
					+ "    \"firstName\": \"Dimitar\",\r\n"
					+ "    \"lastName\": \"Josifov\",\r\n"
					+ "    \"email\": \"jdimitar@gmail.com\"\r\n"
					+ "}");
			postRequest.setEntity(params);
			postRequest.setHeader("Content-Type", "application/json");

			HttpResponse response = client.execute(postRequest);

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
