package com.example.student;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.student.entity.Subject;
import com.example.student.enumeration.SubjectName;
import com.example.student.repository.SubjectRepository;

@SpringBootApplication
public class StudentApplication {

	@Autowired
	SubjectRepository subjectRepo;

//	@Autowired
//	BookRepository bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@PostConstruct
	public void initSubject() {
		System.out.println("Initializing default subjects");

		if (subjectRepo.findByName(SubjectName.ALGEBRA.name()) == null) {
			Subject s1 = new Subject(null, SubjectName.ALGEBRA.name());
			subjectRepo.save(s1);
		}
		if (subjectRepo.findByName(SubjectName.ALGORITHMS.name()) == null) {
			Subject s2 = new Subject(null, SubjectName.ALGORITHMS.name());
			subjectRepo.save(s2);
		}
		if (subjectRepo.findByName(SubjectName.JAVA.name()) == null) {
			Subject s3 = new Subject(null, SubjectName.JAVA.name());
			subjectRepo.save(s3);
		}
		if (subjectRepo.findByName(SubjectName.MATHEMATICS.name()) == null) {
			Subject s4 = new Subject(null, SubjectName.MATHEMATICS.name());
			subjectRepo.save(s4);

		}
		if (subjectRepo.findByName(SubjectName.PHYSICS.name()) == null) {
			Subject s5 = new Subject(null, SubjectName.PHYSICS.name());
			subjectRepo.save(s5);
		}
	}

//	@PostConstruct
//	public void initBook() {
//		System.out.println("Initializing default books");
//
//		if (bookRepo.findByName(BookName.CLEANCODE.name()) == null) {
//			Book b1 = new Book(null, BookName.CLEANCODE.name());
//			bookRepo.save(b1);
//		}
//		if (bookRepo.findByName(BookName.JAVAFUNDAMENTALS.name()) == null) {
//			Book b2 = new Book(null, BookName.JAVAFUNDAMENTALS.name());
//			bookRepo.save(b2);
//		}
//		if (bookRepo.findByName(BookName.MATH.name()) == null) {
//			Book b3 = new Book(null, BookName.MATH.name());
//			bookRepo.save(b3);
//		}
//	}

}
