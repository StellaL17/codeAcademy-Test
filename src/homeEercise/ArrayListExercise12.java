package homeEercise;

public class ArrayListExercise12 {
	
	public static void main(String[] args) {

		Integer niza[] = { 5, 2, 7, 7, 5 };

		for (int i = 1; i <= niza.length - 1; i++) {
			for (int j = i + 1; j < niza.length; j++) {
				if ((niza[i]) == niza[j] && (i != j)) {

					System.out.println("Duplicate element is: " + niza[j]);
				}
			}

		}
	}

}



