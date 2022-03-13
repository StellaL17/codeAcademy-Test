package jaxbStudent;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	
	//Student(name, surname, email, phone, address, index, subjectsgrades)
	@XmlAttribute
	private String index;
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String surname;
	
	@XmlElement
	private Phone phone;
	
	@XmlElement
	private ArrayList<String> emails;
	
	@XmlElement
	private Address address;
	
	@XmlElement
	private ArrayList<Subject> subjects;
	
	@XmlElement
	private ArrayList<Grade> grade;
	
	@XmlElement
	private Double gpa;
	
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

	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public ArrayList<String> getEmails() {
		return emails;
	}
	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public ArrayList<Subject> getSubjects() {
		return subjects;
	}
	public void setSubject(ArrayList<Subject> subjects2) {
		this.subjects = subjects2;
	}
	public ArrayList<Grade> getGrades() {
		return grade;
	}
	public void setGrades(ArrayList<Grade> grade) {
		this.grade = grade;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public Student(String name, String surname, String email, Phone phone, ArrayList<String> emails, Address address,
			String index, Subject subject, ArrayList<Grade> grade, Double gpa) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.emails = emails;
		this.address = address;
		this.index = index;
		this.grade = grade;
		this.gpa = gpa;
	}
	
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", surname=" + surname + ", phone=" + phone + ", emails="
				+ emails + ", address=" + address + ", index=" + index + ", grades=" + grade
				+ ", gpa=" + gpa + "]";
	}

}

