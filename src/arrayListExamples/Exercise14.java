package arrayListExamples;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise14 {

	public static void main(String[] args) {

		ArrayList<String> colors = new ArrayList<>();

		colors.add("Blue");
		colors.add("Red");
		colors.add("White");
		colors.add("Black");
		colors.add("Brown");

		System.out.println("Colors: " + colors);

		// swap element on index 0 with element with index 2

		Collections.swap(colors, 0, 2);

		System.out.println("Colors swapped: " + colors);

		// swap position 1 with position 4

		String t = colors.get(4);

		colors.set(4, colors.get(1));
		colors.set(1, t);

		System.out.println("Modified array: " + colors);

		// swap black and white
		System.out.println(colors.indexOf("Black"));

		// treba da napravime metod koj ke ni prima dva argumenti, prviot argument e
		// listata, vtoriot e bojata,
		// metodot treba da ni vrati integer so indexot na elementot

		Integer indexWhite = vratiIndex(colors, "White");
		Integer indexBlack = vratiIndex(colors, "Black");

		Collections.swap(colors, indexWhite, indexBlack);
		System.out.println(colors);

		Collections.swap(colors, colors.indexOf("White"), colors.indexOf("Black"));

		System.out.println(colors);

		Integer size = izbrojLista(colors);
		System.out.println(size);

		ArrayList<Integer> broevi = new ArrayList<Integer>();
		broevi.add(1);
		broevi.add(2);
		broevi.add(3);
		broevi.add(4);
		broevi.add(5);

		System.out.println(broevi);

		Integer parni = 0;
		Integer neparni = 0;

		parni = totalEvenNumbers(broevi);
		neparni = totalOddNumbers(broevi);
		System.out.println("Vkupno ima: " + parni + " parni broevi, a ima " + neparni + " neparni broevi");

		ParniNeparni res = new ParniNeparni();
		res = parniNeparni(broevi);
		System.out.println("Parni: " + res.getParni() + " Neparni: " + res.getNeparni());

	}

	public static Integer vratiIndex(ArrayList<String> lista, String boja) {

		Integer index = 0;

		for (String color : lista) {
			if (color == boja) {
				return index;

			}
			index++;

		}

		return null;

	}

	// metod sho kje presmeta kolku elementi ima lista, metodot vrakja integer, a
	// prima lista

	public static Integer izbrojLista(ArrayList<String> lista) {

		Integer count = 0;

		for (String string : lista) {
			count++;

		}
		return count;
	}

	// metod sho ke ni kazhe kolku parni broevi imame vo listata

	public static Integer totalEvenNumbers(ArrayList<Integer> lista) {

		Integer count = 0;

		for (Integer broj : lista) {

			if (broj % 2 == 0) {
				count++;

			}

		}
		return count;

	}

	// metod shto ke ni kazhe kolku neparni broevi imame vo listata
	public static Integer totalOddNumbers(ArrayList<Integer> lista) {

		Integer count = 0;

		for (Integer broj : lista) {
			if (broj % 2 != 0) {

				count++;
			}

		}
		return count;
	}

	// metod sho ke ni vrati objekt koj sodrzhi dva parametri (paren i neparen) i
	// ke ni kazhe kolku ima parni, a kolku neparni elementi

	public static ParniNeparni parniNeparni(ArrayList<Integer> lista) {

		ParniNeparni result = new ParniNeparni();
		Integer parni = 0;
		Integer neparni = 0;

		for (Integer broj : lista) {

			if (broj % 2 == 0) { // parni
				parni++;
			} else {
				neparni++;
			}

		}

		result.setParni(parni);
		result.setNeparni(neparni);

		return result;

	}

}
