package homeEercise;

public class Account {
	
	private int number;
	private int balance;
	
	public Account() {
		balance = 100;
	}
	
	public void deposit (int a) {
		balance = balance + a;
	}

	public void withdraw(int a) {
		balance = balance - a;
	}
	
	public int getBalance() {
		return balance;
	}
}
