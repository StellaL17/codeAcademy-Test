package jaxbExample;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class UnmarshallerExample {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Fruit.class);
			
			File file = new File("D:\\fruit.xml");
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			Fruit f = (Fruit) unmarshaller.unmarshal(file);
			
			System.out.println("id: " + f.getId() + ", name: " + f.getName() + ", price: " + f.getPrice());
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
