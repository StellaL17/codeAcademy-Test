package homeEercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetExamples {

	public static void main(String[] args) {

		HashSet<String> clothes = new HashSet<>();

		clothes.add("Blouse");
		clothes.add("Jacket");
		clothes.add("Jeans");

		System.out.println("My HashSet elements are: " + clothes);

		Iterator<String> a = clothes.iterator();

		while (a.hasNext()) {
			System.out.println(a.next());
		}

		System.out.println("My HashSet has " + clothes.size() + " elements.");

		System.out.println("==========================================");

		HashSet<Integer> numbers = new HashSet<Integer>();

		numbers.add(4);
		numbers.add(7);
		numbers.add(8);

		Iterator<Integer> i = numbers.iterator();

		while (i.hasNext()) {
			Integer integer = (Integer) i.next();
			System.out.println(integer);

		}

	}

}
