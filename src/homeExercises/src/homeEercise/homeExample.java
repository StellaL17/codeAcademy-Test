package homeEercise;

public class homeExample {
	
	public static void main(String[] args) {
		
		Integer niza[] = {1,2,3,4,5};
		
		System.out.println(zbir(niza));
		
		
	}
	
	public static Integer zbir(Integer niza[]) {
		
		Integer sum = 0;
		
		for (int i = 0; i < niza.length; i++) {
			sum+= niza[i];
		}
		
		return sum;
	}

}
