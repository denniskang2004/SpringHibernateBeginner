package udemy.springHibernate.C4_Hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//Lazy: loading the dependent entities when neccessary
public class App16_LoadingEagerOrLazy {

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
			session.beginTransaction();
			Query<Instructor> query = 
					session.createQuery(" select i from Instructor i "
							+ " JOIN FETCH i.courses "
							+ " Where i.id =:theInstructorId ",
							Instructor.class);
			query.setParameter("theInstructorId", 15);
			
			// exec query and get instructor
			Instructor temInstructor = query.getSingleResult();
			
			session.getTransaction().commit();
			
			session.close();
			System.out.println("Session closed!");
			
			System.out.println("Courses after session closed:"+temInstructor.getCourses());

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			// handle the leaking issue
			factory.close(); // clean the connection pool
		}
	}

}
