package jaxbStudent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Proffessor {
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String surname;
	
	@XmlElement
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public Proffessor(String name, String surname, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	public Proffessor() {
		super();
	}
	
	@Override
	public String toString() {
		return "Proffessor [name=" + name + ", surname=" + surname + ", email=" + email + "]";
	}

}
