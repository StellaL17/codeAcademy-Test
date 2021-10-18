package arrayListExamples;

import java.util.ArrayList;
import java.util.List;

public class Exercise13 {

	public static void main(String[] args) {

		ArrayList<String> colors1 = new ArrayList<>();

		colors1.add("White");
		colors1.add("Black");
		colors1.add("Red");
		colors1.add("Orange");
		colors1.add("Blue");

		System.out.println("Colors1 array: " + colors1);

		ArrayList<String> colors2 = new ArrayList<>();

		colors2.add("White");
		colors2.add("Black");
		colors2.add("Purple");
		colors2.add("Orange");
		colors2.add("Blue");

		System.out.println("Colors2 array: " + colors2);

		ArrayList<String> result = new ArrayList<>();

		for (String boja : colors1) {

			if (colors2.contains(boja)) {
				result.add("True");

			} else {
				result.add("False");
			}

		}

		System.out.println(result);

	}
}
