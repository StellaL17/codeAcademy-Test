package test;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class NewXMLFile {

	public static void main(String[] args) {

		try {

			JAXBContext cont = JAXBContext.newInstance(NewProducts.class);

			Marshaller marshaller = cont.createMarshaller();

			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Product prod1 = new Product();
			prod1.setId(500001);
			prod1.setName("Gin");
			prod1.setType("newProduct");
			prod1.setPrice("850mkd");
			prod1.setWeight("0.750g");
			prod1.setQuantity("1");

			Product prod2 = new Product();
			prod2.setId(500002);
			prod2.setName("Cognac");
			prod2.setType("newProduct");
			prod2.setPrice("1050mkd");
			prod2.setWeight("0.750g");
			prod2.setQuantity("1");

			Product prod3 = new Product();
			prod3.setId(500003);
			prod3.setName("Votka");
			prod3.setType("newProduct");
			prod3.setPrice("800mkd");
			prod3.setWeight("0.750g");
			prod3.setQuantity("1");

			Product prod4 = new Product();
			prod4.setId(500004);
			prod4.setName("Whiskey");
			prod4.setType("newProduct");
			prod4.setPrice("1250mkd");
			prod4.setWeight("0.750g");
			prod4.setQuantity("1");

			NewProducts lista = new NewProducts();

			lista.getNewProducts().add(prod1);
			lista.getNewProducts().add(prod2);
			lista.getNewProducts().add(prod3);
			lista.getNewProducts().add(prod4);

			marshaller.marshal(lista, new File("D:\\newProducts.xml"));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
