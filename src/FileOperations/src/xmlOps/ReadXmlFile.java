package xmlOps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlFile {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

		// Student(name, surname, email, phone, address, index, subjectsgrades)
		// Address(street, number, city)
		// Phone(mobile, work, home)
		// Subjects(name, schedule, books, proffesor)
		// Grades(Subject, grade, Student)

		Student student1 = new Student();
		Address adresa = new Address();
		Phone phone = new Phone();
		ArrayList<String> emails = new ArrayList();
		ArrayList<Subject> subjects = new ArrayList();

		student1.setName("Aleksandar");
		student1.setSurname("Acev");
		student1.setIndex("123/2021");

		adresa.setCity("Strumica");
		adresa.setNumber("20");
		adresa.setStreet("Patizanska");

		student1.setAddress(adresa);

		phone.setHome("034123456");
		phone.setMobile("077123456");
		phone.setWork("034654321");

		student1.setPhone(phone);

		emails.add("aleksandar@email.com");
		emails.add("a.acev@gmail.com");
		emails.add("acev@email.com");

		student1.setEmails(emails);

		// Subject 1
		Subject matematika1 = new Subject();

		matematika1.setName("Matematika 1");
		matematika1.setSchedule("Ponedelnik, Sreda, Petok");

		ArrayList<Book> knigi = new ArrayList<>();

		Book kniga1 = new Book();
		kniga1.setName("Funkcionalni redovi");
		kniga1.setAuthor("Goran Stanic");
		knigi.add(kniga1);

		matematika1.setBooks(knigi);

		Proffessor profMat = new Proffessor();
		profMat.setName("Aleksandar");
		profMat.setSurname("Smilevski");
		profMat.setEmail("asmilevski@email.com");

		matematika1.setProffessor(profMat);

		subjects.add(matematika1);

		// Subject2
		Subject programiranje = new Subject();

		programiranje.setName("programiranje 1");
		programiranje.setSchedule("Ponedelnik, Sreda");

		ArrayList<Book> knigiProgramiranje = new ArrayList<>();

		Book java = new Book();
		java.setName("Java fundamentals");
		java.setAuthor("Goran Stanic");
		knigiProgramiranje.add(java);

		programiranje.setBooks(knigiProgramiranje);

		Proffessor profProg = new Proffessor();
		profProg.setName("Dimitar");
		profProg.setSurname("Josifov");
		profProg.setEmail("jdimitar@gmail.com");

		programiranje.setProffessor(profProg);

		subjects.add(programiranje);

		student1.setSubject(subjects);

		ArrayList<Grade> oceni = new ArrayList<>();

		Grade ocenaMat = new Grade();
		ocenaMat.setStudentIndex(student1.getIndex());
		ocenaMat.setSubject(matematika1);
		ocenaMat.setGrade(8);

		Grade ocenaProg = new Grade();
		ocenaProg.setStudentIndex(student1.getIndex());
		ocenaProg.setSubject(programiranje);
		ocenaProg.setGrade(10);

		oceni.add(ocenaMat);
		oceni.add(ocenaProg);

		student1.setGrades(oceni);

		// Presmetaj prosek
		Double gpa = prosek(student1.getGrades());
		student1.setGpa(gpa);

		System.out.println(student1.toString());

		// read XML file
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		File f = new File("resources/exampleStudent.xml");

		Document doc = db.parse(f);

		doc.getDocumentElement().normalize();

		System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

		NodeList list = doc.getElementsByTagName("student");

		for (int i = 0; i < list.getLength(); i++) {

			Node node = list.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) node;

				String id = e.getAttribute("studentId");
				System.out.println(id);

				String name = e.getElementsByTagName("name").item(0).getTextContent();
				System.out.println(name);

				String surname = e.getElementsByTagName("surname").item(0).getTextContent();
				System.out.println(surname);
				
				String address = e.getElementsByTagName("address").item(0).getTextContent();
				System.out.println(address);
				
				
				XPathFactory xpf = XPathFactory.newInstance();
		        XPath xpath = xpf.newXPath();
		        String subject = (String) xpath.evaluate("/students/student/subjects/subject", doc, XPathConstants.STRING);
		        System.out.println(subject);
		        
		        String book = (String) xpath.evaluate("/students/student/subjects/subject/books/book/name", doc, XPathConstants.STRING);
		        System.out.println(book);
				
			}
		}

	}

	private static Double prosek(ArrayList<Grade> grades) {

		Double gpa = 0.0;
		Integer sum = 0;

		for (Grade grade : grades) {
			sum = sum + grade.getGrade();
		}
		

		gpa = (double) (sum / grades.size());

		return gpa;

	}
}
