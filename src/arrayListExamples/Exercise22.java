package arrayListExamples;

import java.util.ArrayList;

public class Exercise22 {

	public static void main(String[] args) {

		ArrayList<String> lista1 = new ArrayList<>();

		lista1.add("Orange");
		lista1.add("Blue");
		lista1.add("Red");
		lista1.add("White");
		lista1.add("Black");
		lista1.add("yellow");

		for (int i = 0; i < lista1.size(); i++) {

			System.out.println("Index: " + i + " Value: " + lista1.get(i));

		}

	}

}
