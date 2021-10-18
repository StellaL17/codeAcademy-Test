package arrayListExamples;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise8 {
	
	//sortiraj ja listata

	public static void main(String[] args) {
		

		ArrayList<String> colors = new ArrayList<>();

		colors.add("White");
		colors.add("Black");
		colors.add("Red");
		colors.add("Orange");

		System.out.println("Original array: " + colors);
		
		Collections.sort(colors);
		
		System.out.println("Sorted array: " + colors);
		
		//Sort descending reversed array)
		
		Collections.reverse(colors);
		
		System.out.println("Reversed array: " + colors);
		
		
		
		

	}

}
