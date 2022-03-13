package org.test.hibernateRelations.manyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.test.hibernateRelations.manyToMany.entity.Answer;
import org.test.hibernateRelations.manyToMany.entity.Question;

public class ManyToMany {
	
	static SessionFactory factory;
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		try {
			
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.hibernateRelations.manyToMany.entity.Answer.class);
			cfg.addAnnotatedClass(org.test.hibernateRelations.manyToMany.entity.Question.class);
			
			cfg.configure();
			
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
			//Many to many relation
			
			Question question1 = new Question("What is JAVA?");
			
			Answer answer1_1 = new Answer("Java is prog lang", "Drko");
			Answer answer1_2 = new Answer("Java is super cool lang", "Dimitar");
			
			List<Answer> answers1 = new ArrayList<Answer>();
			
			answers1.add(answer1_1);
			answers1.add(answer1_2);
			
			question1.setAnswers(answers1);
			
			Question question2 = new Question("What is compiler?");
			
			Answer answer2_1 = new Answer("Compiler is translator of source to byte code", "Ognen");
			Answer answer2_2 = new Answer("Compiler is translator", "Dimitar");
			
			List<Answer> answer2 = new ArrayList<Answer>();
			
			answer2.add(answer2_1);
			answer2.add(answer2_2);
			
			question2.setAnswers(answer2);
			
			session.persist(question1);
			session.persist(question2);
			
			
			
			tx.commit();
			session.close();
			
			
		} catch (HibernateException e) {
			System.out.println(e);
		}
		
	}

}
