package udemy.springHibernate.C4_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Lazy: loading the dependent entities when neccessary
public class App17_LazyUsingHQL {

	// To specify loading type --> 
	// when define the mapping relationship i.e.@oneToMany (fetch=FetchType.EAGER/LAZY). 
	
	// If fetchType not specified, default below
	// @oneToOne: eager, @OneToMany: lazy, @ManyToOne:eager, @ManyToMany:lazy
	
	// To fetch lazy data: first open Hibernate session
	// option1: session.get and call getter method
	// option2: Hibernate query with HQL
	
	static public void main(String[] args) {
		// create session factory
		// include the entity class into the factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class) // add course ference
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session
		try {
			// get related courses
			session = factory.getCurrentSession();
			session.beginTransaction();
			Instructor instructor2 = session.get(Instructor.class, 16); // if Lazy, then no courses loaded
			System.out.println("Courses:"+instructor2.getCourses());// only now the courses loaded
			session.getTransaction().commit();
			session.close(); 
			System.out.println("Session closed");
			
			// If Eager is fetchType, then below instructor2 has courses in memrory
			// If Lazy, data can be loaded only if another session open, so call getter before close
			// If Lazy, data can be loaded using HQL JOIN FETCH (see App 17)
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Courses:"+instructor2.getCourses());// only now the courses loaded
			session.getTransaction().commit();
			session.close();
			System.out.println("done!");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// handle the leaking issue
			factory.close(); // clean the connection pool
		}
	}

}
