package doctorExample;

public class Hospital {

	public static void main(String[] args) {
		

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
		
		
		//Call method with parameter
		System.out.println(doc.getInfo("Tom"));
		
		
		Doctor newDoc = new Doctor();
		newDoc.setName("Zan");
		newDoc.setSurname("Mitrev");
		newDoc.setSpeciality("Cardiologist");
		
		
		System.out.println("====================================================");
				
	    System.out.println("Doctor info: \nname: " + newDoc.getName() + "\nsurname: " + newDoc.getSurname());
	    
	    Doctor dimitar = new Doctor("Cardiologist", "Dimitar", "Josifov");
	    
	    
	    System.out.println(dimitar.toString());
	    
	    
	    
	    //Arrays
	    
	    Doctor doktori[] = {new Doctor("Stomatolog", "Tom", "Jones"), new Doctor("Zan", "Mitrev"), new Doctor("Lee", "Cooper")};
	    
	    for (Doctor doctor : doktori) {
			System.out.println("Ime i prezime: " + doctor.getName() + " " + doctor.getSurname());
				
			
		      }
	    
		}
		
		
	}


