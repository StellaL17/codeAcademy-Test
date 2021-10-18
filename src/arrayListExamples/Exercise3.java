package arrayListExamples;

import java.util.ArrayList;

public class Exercise3 {

	public static void main(String[] args) {
		
		ArrayList<String> lista = new ArrayList<>();
		
		lista.add("White");
		lista.add("Black");
		lista.add("Red");
		
		System.out.println("First array: " + lista);
		
		lista.add(0, "BLue");
		
		System.out.println("Modified array: " + lista);
		

	}

}
