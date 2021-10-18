package arrayListExamples;

import java.util.ArrayList;

public class Exercise4 {

	public static void main(String[] args) {
		
		ArrayList<String> colors = new ArrayList<>();
		
		colors.add("White");
		colors.add("Black");
		colors.add("Red");
		colors.add("Orange");
		
		System.out.println("Colors: " + colors);
		
		String black = colors.get(1);
		
		System.out.println("Color with index 1 is " + black);
		System.out.println(colors.get(2));
		
		
	}

}
