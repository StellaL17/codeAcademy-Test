package jaxbStudent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Grade {
	
	//Grades(Subject, grade, Student)
	
	@XmlElement
	private Subject subject;
	
	@XmlElement
	private String studentIndex;
	
	@XmlElement
	private Integer grade;
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getStudentIndex() {
		return studentIndex;
	}
	public void setStudentIndex(String studentIndex) {
		this.studentIndex = studentIndex;
	}
	
	public Grade() {
		super();
	}
	
	public Grade(Subject subject, String studentIndex, Integer grade) {
		super();
		this.subject = subject;
		this.studentIndex = studentIndex;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Grades [subject=" + subject + ", studentIndex=" + studentIndex + ", grade=" + grade + "]";
	}
}
