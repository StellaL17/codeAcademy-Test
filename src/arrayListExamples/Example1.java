package arrayListExamples;

import java.util.ArrayList;

public class Example1 {
	
	public static void main(String[] args) {
		
		ArrayList<String> fruits = new ArrayList<>();
		
		System.out.println(fruits.isEmpty());
		
		fruits.add("Apple");
		fruits.add("Orange");
		
		fruits.add(0, "Watermelon");
		fruits.add("Apple");
		
		System.out.println(fruits.contains("Apple"));
		
		System.out.println("Element with index 1 has value: " + fruits.get(1));
		
		System.out.println(fruits.toString());
		
//		fruits.remove(0);
//		fruits.remove("Apple");
		
//		fruit.clear();
		
		System.out.println(fruits);
		
		
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
	}

}
