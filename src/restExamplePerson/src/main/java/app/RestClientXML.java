package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class RestClientXML {

	public static void main(String[] args) {

		try {

			// Create http client
			HttpClient httpClient = HttpClientBuilder.create().build();

			// Create request
			HttpGet getRequest = new HttpGet("http://localhost:8080/restExample/rest/person/getAll");

			// Add additonall headers parameters
			getRequest.addHeader("accept", "application/xml");

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
				List<Person> people = parseXMLResponse(output);
				System.out.println("test");
			}


		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static List<Person> parseXMLResponse(String output) throws SAXException, IOException, ParserConfigurationException {

		List<Person> result = new ArrayList<>();
		
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(output.toString())));
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		
		for(int i = 0; i<nodeList.getLength(); i++) {
			
			Node node = nodeList.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				
				Element element = (Element) nodeList.item(i);
				
				if(element.getNodeName().contains("person")) {
					System.out.println( "Id: " + element.getElementsByTagName("id").item(0).getTextContent());
					System.out.println("First name: " + element.getElementsByTagName("firstName").item(0).getTextContent());
					System.out.println( "LastName: " + element.getElementsByTagName("lastName").item(0).getTextContent());
					System.out.println("Email: " + element.getElementsByTagName("email").item(0).getTextContent());
					
					Person p = new Person();
					
					p.setId(Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent()));
					p.setFirstName(element.getElementsByTagName("firstName").item(0).getTextContent());
					p.setLastName(element.getElementsByTagName("lastName").item(0).getTextContent());
					p.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
					
					result.add(p);
					
				}
				
				
			}
			
		}
		

		return result;
	}

}
