package arrayListExamples;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise9 {

	public static void main(String[] args) {
		
		ArrayList<String> colors = new ArrayList<>();

		colors.add("White");
		colors.add("Black");
		colors.add("Red");
		colors.add("Orange");

		System.out.println("Original array: " + colors);
		
		ArrayList<String> numbers = new ArrayList<>();
		
		numbers.add("1");
		numbers.add("2");
		numbers.add("3");
		numbers.add("4");
		
		System.out.println("Number array: " + numbers);
		
		Collections.copy(colors, numbers);
		
		System.out.println("Colors array: " + colors);

	}

}
