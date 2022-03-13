package homeEercise;

public class LoopsCond {

	public static void main(String[] args) {

		Integer month = 2;

		switch (month) {
		case 1:
			System.out.println("January");
			break;

		case 2:
			System.out.println("February");
			break;

		case 3:
			System.out.println("March");
			break;

		default:
			System.out.println("Month doesn't exist");
			break;
		}

		System.out.println("=============================");

		Integer x = 5;

		if (x > 10) {
			System.out.println(x + " e pogolemo od 10");
		} else if (x > 15) {
			System.out.println(x + " e pogolemo od 10");
		} else if (x < 10) {
			System.out.println(x + " e pomalo od 10");
		} else {
			System.out.println("We don't have the right answer");
		}

		System.out.println("=============================");

		Integer i = 0;

		while (i < 6) {
			System.out.println(i);
			i++;

		}

		Integer s = 1;

		do {
			System.out.println(s);
			s++;
		} while (s < 5);

	}

}
