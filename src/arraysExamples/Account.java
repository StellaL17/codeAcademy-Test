package arraysExamples;

public class Account {
	
	//Class parameters
	Integer a;
	Integer b;
	
	//constructor with 2 parameters
	public Account(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}


	@Override
	public String toString() {
		return "Account [a=" + a + ", b=" + b + "]";
	}
	
	
	//set a and b with parameters from input (c, d)
	public void setData(Integer c, Integer d) {
		
		
		a=c;
		b=d;
		
	}
	
	//prints object values
	public void showData() {
		
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}
	
	
	//default constructor
	public Account() {
		super();
	}
	
}
