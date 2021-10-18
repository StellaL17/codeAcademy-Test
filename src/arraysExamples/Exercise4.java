package arraysExamples;

public class Exercise4 {
	
	public static void main(String[] args) {
		
		Integer niza[] = {3, 4, 5, 7, 9};
		
		System.out.println(average(niza));
			
	}
	
	public static Double average(Integer niza[]) {
	     Double result = 0.0;
	     
	     Double sum = zbir(niza);
	     
	     result = (double) (sum / niza.length);
	
	      return result;
		
	}
	
	public static Double zbir(Integer niza[]) {
		Double suma = (double)0;
		
		for (int i = 0; i < niza.length; i++) {
			suma+= niza[i];
			
		}
		
		return suma;
    }
	
}	
	
	
	
	
