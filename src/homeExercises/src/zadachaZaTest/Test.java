package zadachaZaTest;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		File fajl = new File("D:\\Products_xml.xml");

		Document doc = db.parse(fajl);

		doc.getDocumentElement().normalize();
		
		NodeList lista = doc.getElementsByTagName("articles");
		
		for (int i = 0; i < lista.getLength(); i++) {
			
			Node node = lista.item(i);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;
				
				String articleId = e.getElementsByTagName("article").item(0).getTextContent();
				System.out.println(articleId);
				
				
				
			}
			
			
		}
		
//		System.out.println("Lista na artikli: " + lista);
	}

	public static Integer vkupnoArtikli(String List) {
		
		Integer count = 0;
		
		
		return null;

	}
}
