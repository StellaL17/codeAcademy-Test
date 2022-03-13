package jaxbStudent;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="subject")
@XmlAccessorType(XmlAccessType.FIELD)
public class Subject {
	
	//Subjects(name, schedule, books, proffesor)
	
	@XmlElement
	private String name;
	
	@XmlElement
	private String schedule;
	
	@XmlElement
	private ArrayList<Book> books;
	
	@XmlElement
	private Proffessor proffessor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public ArrayList<Book> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	public Proffessor getProffessor() {
		return proffessor;
	}
	public void setProffessor(Proffessor proffessor) {
		this.proffessor = proffessor;
	}
	
	public Subject(String name, String schedule, ArrayList<Book> books, Proffessor proffessor) {
		super();
		this.name = name;
		this.schedule = schedule;
		this.books = books;
		this.proffessor = proffessor;
	}
	public Subject() {
		super();
	}
	
	@Override
	public String toString() {
		return "Subject [name=" + name + ", schedule=" + schedule + ", books=" + books + ", proffessor=" + proffessor
				+ "]";
	}

}
