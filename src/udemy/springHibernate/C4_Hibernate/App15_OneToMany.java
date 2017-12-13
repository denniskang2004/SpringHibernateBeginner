package udemy.springHibernate.C4_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// One instructor --> many courses
public class App15_OneToMany {

	// Steps
	// create tables (instructor, course with foreign key to instructorId)
	// create courses class (instructor already created)
	// course class: constructor, ToString, @Entity/@Table add instructor field (@ManyToOne , @JoinColumn)
	// instructor class: add courses field (@OneToMany, @MappedBy), addCourse function
	// Result: instructor <---> courses (bi-relational)
	
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
			
			// instructor
			long randId = Math.round(Math.random());
			Instructor instructor = new Instructor("james"+randId, "kang3", "email2@gmail.com");
			InstructorDetail detail = new InstructorDetail("tennis"+randId, "dallas3");
			instructor.setInstructorDetailId(detail);
			Course course = new Course("DataBase 10"+randId);
			instructor.addCourse(course);
			session.save(instructor);
			session.save(course);
			session.getTransaction().commit();
			
			// get related courses
			session = factory.getCurrentSession();
			session.beginTransaction();
			Instructor instructor2 = session.get(Instructor.class, instructor.getId());
			System.out.println("Courses:"+instructor2.getCourses());
			
			// delete course
			
			System.out.println("done!");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close(); // handle the leaking issue
			factory.close(); // clean the connection pool
		}
	}

}
