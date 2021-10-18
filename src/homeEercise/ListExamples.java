package homeEercise;

import java.util.ArrayList;
import java.util.Collections;

public class ListExamples {

	public static void main(String[] args) {
		
		ArrayList<String> cars = new ArrayList<>();
		
		cars.add("Bmw");
		cars.add("Mercedes");
		cars.add("Audi");
		
		System.out.println("Original array: " + cars);
		
		System.out.println(cars.isEmpty());
		
		for (String car : cars) {
			System.out.println(car);
			
		}
		
		
		
		
		

	}

}
