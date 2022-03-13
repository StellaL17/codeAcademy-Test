package org.test.hibernateRelations.compositeKey;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.test.hibernateRelations.compositeKey.entity.Student;
import org.test.hibernateRelations.compositeKey.entity.StudentId;

public class CompositeKey {
	
	static SessionFactory factory;
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.hibernateRelations.compositeKey.entity.StudentId.class);
			cfg.addAnnotatedClass(org.test.hibernateRelations.compositeKey.entity.Student.class);
			
			
			cfg.configure();
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			
			tx = session.beginTransaction();
			
			StudentId stId = new StudentId(1L, "123/2021");
			
			Student st = new Student(stId, "Aleksandar Acev");
			
			session.save(st);
			
			
			tx.commit();
			session.close();
			
			
		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}
		
	}

}
