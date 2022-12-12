package org.example;


import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();


        session.beginTransaction();

        Person person = new Person("Some Name", 25);
        session.save(person);



        session.getTransaction().commit();

        System.out.println(person.getId());

        sessionFactory.close();

    }
}
