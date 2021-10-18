package doctorExample;

public class Surgeon extends Doctor {
	
	 
		public void getSurgeonDetails() {
			
			System.out.println("Surgeon details");
		}
		
		//overrided method
        public void getDoctorDetails() {
			
			System.out.println("Doctor details modified - from Surgeon class");
      }

		public Surgeon() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Surgeon(String speciality, String name, String surname) {
			super(speciality, name, surname);
			// TODO Auto-generated constructor stub
		}

		public Surgeon(String name, String surname) {
			super(name, surname);
			// TODO Auto-generated constructor stub
		}
        
        
        
}  

