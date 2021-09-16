package doctorExample;

public class Hospital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Surgeon s = new Surgeon();
		//method from Surgeon class
		s.getSurgeonDetails();
		
		
		//overrided method
		s.getDoctorDetails();
		
		
		
		Doctor d = new Surgeon();
		d.getDoctorDetails();
		
		
		Doctor doc = new Doctor();
		doc.getDoctorDetails();
		
//		this will not work due to private fields in Doctor class
//		doc.name = "Sam";
		
		//Setter example
		doc.setName("Sam");
		
		//Gettter example
		System.out.println(doc.getName());
		
		System.out.println(doc.getInfo("Tom"));
		
		
		
		
	}

}
