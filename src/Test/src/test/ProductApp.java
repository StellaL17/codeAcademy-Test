package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ProductApp {

	public static void main(String[] args) throws JAXBException {

		String filePath = "resources/products.xml";

		Products lista = readFile(filePath);

		System.out.println(lista.getProducts());

		System.out.println("Vkupno ima: " + lista.getProducts().size() + " produkti");

		minMax(lista.getProducts());

		countDuplicates(lista.getProducts());

		typeLista(lista.getProducts());

	}

	private static void typeLista(List<Product> produkti) {

		HashMap<String, ArrayList<Product>> typeMap = new HashMap<>();

		List<List<Product>> typeList = new ArrayList<List<Product>>();

		Integer count = 0;

		for (int i = 0; i < produkti.size(); i++) {

			List<Product> lista = new ArrayList<>();

			for (Product product : produkti) {
				if (produkti.get(i).getType().equals(product.getType())) {

					lista.add(product);

				}
				typeList.add(lista);
				typeMap.put(produkti.get(i).getType(), (ArrayList<Product>) typeList.get(count));
				count++;

			}
		}
		System.out.println(typeMap);

	}

	private static void countDuplicates(List<Product> products) {

		HashMap<String, Integer> countType = new HashMap<>();

		Integer type = 0;

		for (int i = 0; i < products.size(); i++) {

			for (Product product : products) {
				if (products.get(i).getType().equals(product.getType())) {
					type++;
				}

				countType.put(products.get(i).getType(), type);

			}
			type = 0;

		}
		System.out.println(countType);

	}

	private static void minMax(List<Product> products) {

		HashMap<Integer, Double> priceMap = new HashMap<>();

		for (Product product : products) {

			Integer prodPrice = getPriceAsInt(product.getPrice());

			Double quantity = Double.valueOf(product.getQuantity());

			priceMap.put(product.getId(), prodPrice * quantity);

		}

		Collections.max(priceMap.values());

		Set<Integer> keys = priceMap.keySet();
		Double min = 0.0;
		Double max = 0.0;
		Integer minProdKey = 0;
		Integer maxProdKey = 0;

		Boolean flag = true;

		for (Integer key : keys) {

			if (flag) {
				min = priceMap.get(key);
				minProdKey = key;
				max = priceMap.get(key);
				maxProdKey = key;
				flag = false;
			}

			if (min > priceMap.get(key)) {
				min = priceMap.get(key);
				minProdKey = key;
			}
			if (max < priceMap.get(key)) {
				max = priceMap.get(key);
				maxProdKey = key;
			}

		}

		System.out.println("Lowest price product: " + minProdKey);

		System.out.println("Highest price product: " + maxProdKey);

	}

	private static Products readFile(String filePath) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Products.class);

		File f = new File(filePath);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		Products prod = (Products) unmarshaller.unmarshal(f);

		return prod;

	}

	public static Integer getPriceAsInt(String priceWithMKD) {

		char[] listFromString = priceWithMKD.toCharArray();
		Integer length = listFromString.length;
		String value = priceWithMKD.substring(0, length - 3);

		Integer a = Integer.parseInt(value);

		return a;
	}

}
