package test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Products {
	
	@XmlElement(name = "product")
	List<Product> products = new ArrayList<Product>();

	public List<Product> getProducts() {
		return products;
	}

	public Products() {
		super();
	}

	@Override
	public String toString() {
		return "Products [products=" + products + "]";
	}


}
