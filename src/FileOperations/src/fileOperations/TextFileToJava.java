package fileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TextFileToJava {

	public static void main(String[] args) throws IOException {

		String filePath = "resources/data.txt";

		HashMap<String, String> result = new HashMap<String, String>();

		BufferedReader br = null;

		File file = new File(filePath);

		try {
			
			br = new BufferedReader(new FileReader(file));

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		String line = null;

		try {
			
			while ((line = br.readLine()) != null) {
	
			    String[] elements = line.split("=");
				result.put(elements[0], elements[1]);
			}
		
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Map: " + result);

		User u = new User();
		u.setName(result.get("name"));
		u.setSurname(result.get("surname"));
//		u.setAddress(result.get("address"));
		u.setPhone(result.get("phone"));
		u.setEmail(result.get("email"));

		System.out.println(u.toString());
	
		
		HashMap<String, String> mapa = txtToMap(filePath);
		
		Set<String> keys = mapa.keySet();
		
		Address adresaOdFile = new Address();
		adresaOdFile.setCity(mapa.get("address.city"));
		adresaOdFile.setNumber(Integer.parseInt(mapa.get("adress.number")));
		adresaOdFile.setStreet(mapa.get("address.street"));
		
//		// Adress object
//		Address addr2 = new Address("Skopje", 15, "Partizanska");
		
//		Adress object with values from file
//		User user2 = new User("Dimitar", "Josifov", "071515151", adresaOdFile, "mail@mail");
//		user2.getAddress().getNumber();
//		System.out.println(user2);
		
		ArrayList<Address> adresi = new ArrayList<>();
		
		Address doma = new Address("Skopje", 23, "Ilindenska");
		Address rabota = new Address("Skopje", 12, "V Macukovski");
		
		adresi.add(doma);
		adresi.add(rabota);
		
		String ime = "martin";
		
		User martin = new User();
		martin.setName("Martin");
		martin.setSurname("Tasevski");
		martin.setEmail("martin@gmail.com");
		martin.setPhone("12345678");
		
		martin.setListOfAddress(adresi);
		
		// Izvadi ja prvata adresa od martin objektot
		Address addr = martin.getListOfAddress().get(0);
		
		
		for (Address address : martin.getListOfAddress()) {
			
		}
		
	}		
	
    // Method for parsing text file
	public static HashMap<String, String> txtToMap(String filePath) throws IOException {

		HashMap<String, String> result = new HashMap<String, String>();

		BufferedReader br = null;

		File file = new File(filePath);

		br = new BufferedReader(new FileReader(file));

		String line = null;

		br.readLine();

		while ((line = br.readLine()) != null) {

			String[] elements = line.split("=");

			result.put(elements[0], elements[1]);

		}
		
		return result;

	}
}