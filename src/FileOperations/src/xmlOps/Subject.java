package xmlOps;

import java.util.ArrayList;

public class Subject {
	
	//Subjects(name, schedule, books, proffesor)
	
	private String name;
	private String schedule;
	private ArrayList<Book> books;
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
