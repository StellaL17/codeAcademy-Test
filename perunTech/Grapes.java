package perunTech;

import java.util.Scanner;

public class Grapes {
	
	public static void main(String[] args) {
		
		System.out.println("Enter kg: ");		
		Scanner sc = new Scanner(System.in);
		int kg = sc.nextInt();
		
		double a = 30;
		double b = 100;
		double c = 60;
		
		int math = 0;
		int res = 0;
		
		if (kg <= 1000) {
	         math = (int) ((b / b) * a);
	         res = kg * math;       
	         System.out.println("For " + kg + "kg grapes, the price is " + res + " denars" );
	      } else if (kg >= 1001 && kg <= 5000) {
	         math = (int) ((c / b) * a);
	         res = kg * math;
	         System.out.println("For " + kg + "kg grapes, the price is " + res + " denars" );
	      } else if (kg >= 5001) {
		     math = (int) ((b / b) * a);
		     res = kg * math;
		     System.out.println("For " + kg + "kg grapes, the price is " + res + " denars" );
	      } else {
	    	 System.out.println("Invalid input");
		} 
	}

}
