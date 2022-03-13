package articlesExample;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ArticleApp {

	public static void main(String[] args) throws JAXBException {

		String filePath = "resources/products_xml.xml";

		Articles lista = readXMLFile(filePath);

		System.out.println(lista.getArticles());
		System.out.println("Vkupno ima: " + lista.getArticles().size() + " artikli");

		minMax(lista.getArticles());

		countDuplicates(lista.getArticles());

		// vtoro baranje
//		Article a1 = new Article();
//		a1.setId("100004");
//		a1.setName("Pepsi");
//		a1.setPrice("50mkd");
//		a1.setQuantity("1");
//		a1.setWeight("1.5kg");
//		a1.setType("drink");
//		
//		lista.getArticles().add(a1);

		// marshaller na ovaa lista

	}

	private static void countDuplicates(List<Article> articles) {

		HashMap<String, Integer> count = new HashMap<>();

		Integer counter = 0;

		for (int i = 0; i < articles.size(); i++) {

			for (Article article : articles) {
				if (articles.get(i).getName().equals(article.getName())) {
					counter++;
				}

				count.put(articles.get(i).getName(), counter);

			}
			counter = 0;

		}
		System.out.println(count);
	}

	private static void minMax(List<Article> articles) {

		HashMap<Integer, Double> priceMap = new HashMap<>();

		for (Article article : articles) {

			Integer articlePrice = getPriceAsInt(article.getPrice());

			Double quantity = Double.valueOf(article.getQuantity());

			System.out.println("Vkupna suma: " + articlePrice * quantity);
			priceMap.put(article.getId(), articlePrice * quantity);

		}

		System.out.println(priceMap);

		Collections.max(priceMap.values());

		Set<Integer> keys = priceMap.keySet();
		Double min = 0.0;
		Double max = 0.0;
		Integer minArtKey = 0;
		Integer maxArtKey = 0;

		Boolean flag = true;

		for (Integer key : keys) {

			if (flag) {
				min = priceMap.get(key);
				minArtKey = key;
				max = priceMap.get(key);
				maxArtKey = key;
				flag = false;
			}

			if (min > priceMap.get(key)) {
				min = priceMap.get(key);
				minArtKey = key;
			}
			if (max < priceMap.get(key)) {
				max = priceMap.get(key);
				maxArtKey = key;
			}

		}

		System.out.println("Article with lowest price: " + minArtKey + " " + min);
		System.out.println("Article with highest price: " + maxArtKey + " " + max);

		for (Article article : articles) {

			if (minArtKey.equals(article.getId())) {
				System.out.println("Minimum cena: " + article.getName());
			}
			if (maxArtKey.equals(article.getId())) {
				System.out.println("Maksimum cena: " + article.getName());
			}

		}

	}

	private static Articles readXMLFile(String filePath) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Articles.class);

		File file = new File(filePath);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		Articles a = (Articles) unmarshaller.unmarshal(file);

		return a;

	}

	public static Integer getPriceAsInt(String priceWithMkd) {

		char[] listFromString = priceWithMkd.toCharArray();
		Integer length = listFromString.length;
		String value = priceWithMkd.substring(0, length - 3);

		Integer x = Integer.parseInt(value);

		return x;
	}

}
