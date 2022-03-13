package totalPriceExample;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TotalPriceDOM {

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		File f = new File("D:\\fruits.xml");

		Document doc = db.parse(f);

		doc.getDocumentElement().normalize();

		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		NodeList list = doc.getElementsByTagName("fruit");

		Integer totalPrice = 0;

		for (int i = 0; i < list.getLength(); i++) {

			Node node = list.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;

				String id = e.getAttribute("id");

				String name = e.getElementsByTagName("name").item(0).getTextContent();
				System.out.println(name);

				String price = e.getElementsByTagName("price").item(0).getTextContent();
				System.out.println(price);

				totalPrice = totalPrice + getPriceAsInt(price);

//				XPathFactory xpf = XPathFactory.newInstance();
//		        XPath xpath = xpf.newXPath();
//		        String subject = (String) xpath.evaluate("/students/student/subjects/subject", doc, XPathConstants.STRING);
//		        System.out.println(subject);
//		        
//		        String book = (String) xpath.evaluate("/students/student/subjects/subject/books/book/name", doc, XPathConstants.STRING);
//		        System.out.println(book);

			}

			System.out.println("Total price: " + totalPrice);
		}
	}

	public static Integer getPriceAsInt(String priceWithMkd) {

		char[] listFromString = priceWithMkd.toCharArray();
		Integer length = listFromString.length;
		String value = priceWithMkd.substring(0, length - 3);

		Integer x = Integer.parseInt(value);

		return x;

	}

}
