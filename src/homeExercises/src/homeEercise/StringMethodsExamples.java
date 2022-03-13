package homeEercise;

public class StringMethodsExamples {

	public static void main(String[] args) {
		
		char[] arrSample = { 'R', 'O', 'S', 'E' };
		
		String strSample = new String(arrSample);
		
		System.out.println(strSample);

		System.out.println(strSample.length());

		String add = " is Red";
		
		System.out.println(add.toUpperCase());
		System.out.println(strSample.concat(add));

		System.out.println(strSample.indexOf("E"));

		String duplicate = "Better place";
		System.out.println(duplicate.indexOf("t"));

		System.out.println(duplicate.charAt(5));

		System.out.println(duplicate.compareTo(add));

		String a = "I am";
		String b = "Shy";
		System.out.println(a.compareTo("I am"));

		System.out.println(duplicate.contains("ace"));

		String letter = "I am so excited that I am gonna explode from laughing.";
		System.out.println(letter);
		System.out.println("Modified letter: " + letter.replace("am", "was"));

	}

}
