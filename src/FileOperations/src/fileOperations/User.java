package fileOperations;

import java.util.ArrayList;

public class User {
	
	private String name;
	private String surname;
	private String phone;
	
	private ArrayList<Address> listOfAddress;
	
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		super();
	}
	
	public ArrayList<Address> getListOfAddress() {
		return listOfAddress;
	}
	public void setListOfAddress(ArrayList<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}
	
	public User(String name, String surname, String phone, ArrayList<Address> listOfAddress, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.listOfAddress = listOfAddress;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", phone=" + phone + ", listOfAddress=" + listOfAddress
				+ ", email=" + email + "]";
	}
	
}
	
	