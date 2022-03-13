package org.test.soapExample.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.test.soapExample.entity.Person;

public class PersonDAO {
	
	static SessionFactory factory;
	static Transaction tx = null;
	
	public static Session initDB() {
		
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(org.test.soapExample.entity.Person.class);

		cfg.configure();

		factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		
		return session;
		
	}

	public static String insertPersonInDb(Person person) {

		Transaction tx = null;
		try {

			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.soapExample.entity.Person.class);

			cfg.configure();

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();

			tx = session.beginTransaction();

			session.save(person);

			tx.commit();

			session.close();
			return "Person with id: " + person.getId() + "has been created";

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
		}
		return null;
	}
	
	public static List<Person> getAllFromDb() {
		
		List<Person> result = new ArrayList<Person>();
		
		try {
			Session s = initDB();
			tx = s.beginTransaction();
			
			result = s.createQuery("SELECT p FROM Person AS p").list();

			tx.commit();
			s.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
		return result;
	}

}
