package arrayListExamples;

import java.util.ArrayList;

public class Exercise15 {

	public static void main(String[] args) {

		ArrayList<String> lista1 = new ArrayList<>();
		ArrayList<String> lista2 = new ArrayList<>();
		ArrayList<String> result = new ArrayList<>();

		lista1.add("Orange");
		lista1.add("Blue");
		lista1.add("Red");
		lista1.add("White");
		lista1.add("Black");

		lista2.add("Pink");
		lista2.add("Gray");
		lista2.add("Brown");
		lista2.add("Purple");
		lista2.add("Green");
		lista2.add("Yellow");

//		result.addAll(lista1);
//		result.addAll(lista2);

		result = merge(lista1, lista2);

		System.out.println("Result: " + result);

	}

	public static ArrayList<String> merge(ArrayList<String> lista1, ArrayList<String> lista2) {

		ArrayList<String> result = new ArrayList<>();

		result.addAll(lista1);
		result.addAll(lista2);

		return result;
		
		

	}
}
