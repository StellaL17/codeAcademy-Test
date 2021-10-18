package arrayListExamples;

import java.util.ArrayList;

public class Exercise2 {

	public static void main(String[] args) {

		ArrayList<String> colors = new ArrayList<>();

		colors.add("Red");
		colors.add("Green");
		colors.add("Orange");
		colors.add("White");
		colors.add("Black");
		
		for (String color : colors) {
			
			System.out.println("Color: " + color);
			
		}
	}

}
