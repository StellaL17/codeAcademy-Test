package arraysExamples;

import java.util.Arrays;

public class Exercise7 {
	
	public static void main(String[] args) {
		
		Integer niza[] = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
	
	    System.out.println("Originalna niza: " + Arrays.toString(niza));
	
	    //Otstrani go vtoriot element vo nizata (index=1, value=14)
	    
	    Integer removeIndex = 1;
	    
	    for(int i = removeIndex; i < niza.length - 1; i++) {
	    	
	    	niza[i] = niza[i + 1];
	    	
	    	
	    }
	    
	    System.out.println("Modificirana niza: " + Arrays.toString(niza));
	    
	    System.out.println("========================zadaca 2==============");
	
	    Integer novaNiza[] = {25, 14, 56, 15, 36, 56, 77, 18, 29, 49};
	    
	    removeNumber(14, novaNiza);
	    
	}
	
	
	public static void removeNumber(Integer n, Integer niza[]) {
		
		System.out.println("Originalna niza " + Arrays.toString(niza));
		
		Integer index = findIndex(n, niza);
		
		for (int i = index; i < niza.length - 1; i++) {
			
			System.out.println("niza[" + i + "] " + niza[i] + " = niza[" + (i + 1) + "]" + niza[i+1]);
			niza[i] = niza[i + 1];
			
		}
		//reshenieto od nizava premestete go vo nova niza pokratka za eden element
		
		Integer novaModificiranaNiza[] = new Integer[9];
		
		for (int i = 0; i < novaModificiranaNiza.length; i++) {
			novaModificiranaNiza[i] = niza[i];
		}
		
		
		System.out.println("Modificirana niza: " + Arrays.toString(niza));
		System.out.println("Novata modificirana niza: " + Arrays.toString(novaModificiranaNiza));
	}


	private static Integer findIndex(Integer n, Integer[] niza) {
		
		for (int i = 0; i < niza.length; i++) {
			if(niza[i] == n) {
				return i;
			}
			
		}
		
		return null;
		
	}

}

