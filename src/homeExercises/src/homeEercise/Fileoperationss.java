package homeEercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Fileoperationss {
	
	public static void main(String[] args) {
		
		String filePath = "D:\\Watch/txt file.txt";
		
		HashMap <String, String> mapa = new HashMap<String, String>();
		
		BufferedReader chitach = null;
		
		File fajl = new File(filePath);
		
		try {
			chitach = new BufferedReader(new FileReader(fajl));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String line = null;
		
		try {
			while ((line = chitach.readLine()) != null) {
				
				String[] lista = line.split(":");
				mapa.put(lista[0], lista[1]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Mapa:" + mapa);
		
	}

}
