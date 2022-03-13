package zadachaZaTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Vaka {

	public static void main(String[] args) {
		
		String filePath = "D:\\Products_xml.xml";
		
		HashMap<String, String> result = new HashMap<String, String>();
		
		BufferedReader br = null;
		
		File fajl = new File(filePath);
		
		try {
			br = new BufferedReader(new FileReader(fajl));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = null;
		
		try {
			
			while ((line = br.readLine()) != null) {
				
				String[] lista = line.split(">");
				result.put(lista[0], lista[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Lista na artikli: " + result);

	}
	
	public static Integer vkupnoArtikli(String filePath) {
		
		Integer count = 0;
		
		return null;
	}

}
