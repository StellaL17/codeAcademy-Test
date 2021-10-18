package arraysExamples;

public class ExamplePPT {
	
// Example from ppt slide 36
	public static void main(String[] args) {
		
		
		//1 niza od tip account so dolzhina 2 objekta
		Account accounts[] = new Account [2];
		
		
		Account prv = new Account(1, 2);
		Account vtor = new Account(3, 4);
		
		
		accounts[0] = prv;
		accounts[1] = vtor;
		
		
		System.out.println(accounts[0].toString());
		System.out.println(accounts[1].toString());
		
		//Vtora niza
		Account niza[] = new Account[2];
		niza[0] = new Account();
		niza[1] = new Account();
		
		
		niza[0].setData(5,6);
		niza[1].setData(7,8);
		
		
		niza[0].showData();	
		niza[1].showData();	

	}
	
	
	
	

}
