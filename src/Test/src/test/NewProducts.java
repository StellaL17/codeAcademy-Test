package test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class NewProducts {
	
	@XmlElement(name = "product")
	List<Product> newProducts = new ArrayList<>();

	public List<Product> getNewProducts() {
		return newProducts;
	}

	public NewProducts() {
		super();
	}

	@Override
	public String toString() {
		return "NewProducts [newProducts=" + newProducts + "]";
	}
	

}
