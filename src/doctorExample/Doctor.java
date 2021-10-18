package doctorExample;

public class Doctor {
	
	private String speciality;
	private String name;
	private String surname;
	
	
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void getDoctorDetails() {
		
		System.out.println("Doctor details");
		
	}
	
	public String getInfo(String ime) {
		
		return "Doctor name from attribute: " + this.name  + " \nDoctor name: " + ime;
		
	}
	
	//default-en constructor
	public Doctor() {
		super();
	}

	//contructor so nekolku parametri vkluceni
	public Doctor(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	//constructor so site parametri vkluceni
	public Doctor(String speciality, String name, String surname) {
		super();
		this.speciality = speciality;
		this.name = name;
		this.surname = surname;
		
	}
	
    //toString metodata za da gi popolnime site parametri naednash
	@Override
	public String toString() {
		return "Doctor [speciality=" + speciality + ", name=" + name + ", surname=" + surname + "]";
		
	}
	
	
}	

    