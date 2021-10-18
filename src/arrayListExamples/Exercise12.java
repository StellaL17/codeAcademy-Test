package arrayListExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise12 {

	public static void main(String[] args) {
		
		ArrayList<String> colors = new ArrayList<>();

		colors.add("White");
		colors.add("Black");
		colors.add("Red");
		colors.add("Orange");
		colors.add("Blue");

		System.out.println("Colors array: " + colors);
		
		List<String> nova = colors.subList(0, 3);
		
		System.out.println("Nova lista " + nova);
		

	}

}
