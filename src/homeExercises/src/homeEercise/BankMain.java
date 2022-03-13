package homeEercise;

public class BankMain {

	public static void main(String[] args) {
		
		Account cust1 = new Account();
		cust1.deposit(50);
		
		
		System.out.println(cust1.getBalance());
		

	}

}
