package doctorExample;

public class Surgeon extends Doctor {
	
	 
		public void getSurgeonDetails() {
			
			System.out.println("Surgeon details");
		}
		
		//overrided method
        public void getDoctorDetails() {
			
			System.out.println("Doctor details modified - from Surgeon class");
}
}


