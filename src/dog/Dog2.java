package dog;

    public class Dog2 {
	
	   String breed;
	   String size;
	   Integer age;
       String color;
	
	public String getInfo() {
	   return " Dog breed: " + breed + " Dog size: " + size +" Dog age: " + age +" Dog color: " + color;
}
  
	
	public static void main(String[] args) {
		
	   Dog2 germanshepherd = new Dog2();
		
	   germanshepherd.breed = "germanshepherd";
	   germanshepherd.size = "big";
	   germanshepherd.age = 10;
	   germanshepherd.color = "black and brown";
		
		String res = germanshepherd.getInfo();
		
		System.out.println(res);

}}
