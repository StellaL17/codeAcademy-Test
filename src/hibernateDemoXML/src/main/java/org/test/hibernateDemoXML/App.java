package org.test.hibernateDemoXML;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.test.hibernateDemoXML.entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata m = new MetadataSources(ssr).getMetadataBuilder().build();
        
        SessionFactory factory = m.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        
        Transaction t = session.beginTransaction();
        
        Employee e1 = new Employee(2, "Dimitar", "Josifov", "15300");
        
        session.save(e1);
        
        t.commit();
        
        factory.close();
        session.close();
    }
}