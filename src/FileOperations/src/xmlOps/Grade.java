package xmlOps;

public class Grade {
	
	//Grades(Subject, grade, Student)
	
	private Subject subject;
	private String studentIndex;
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
