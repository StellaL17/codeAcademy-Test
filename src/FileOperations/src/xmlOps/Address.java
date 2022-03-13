package xmlOps;

public class Address {
	
	//Address(street, number, city)
	
	private String street;
	private String number;
	private String city;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Address(String street, String number, String city) {
		super();
		this.street = street;
		this.number = number;
		this.city = city;
	}
	
	public Address() {
		super();
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", number=" + number + ", city=" + city + "]";
	}
	
}
