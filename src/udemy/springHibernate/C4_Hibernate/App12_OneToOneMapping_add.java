package udemy.springHibernate.C4_Hibernate;
/* Concepts*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// one-to-one:  
// table 1 --> table 2 .ie. instructor(detail_id fk) & instructorDetails(id)

// one-to-many: i.e. instructor & courses 

// many-to-many: i.e. student & courses

// Cascade: apply same operation to related entities linked by foreign key. (save instructor will save instructorDetails)

// Eager vs. Lazy Loading: configurable

/* Entity Lifecyle : need to revisit and understand. */

/* Cascade type */
// Persiste: save --> related also saved
// Remove: delete
// Refresh: will also refresh related
// Detach
// Merge
// All
// ATTN: by default: no operations cascaded.
public class App12_OneToOneMapping_add {

	// development process

	// 1. prep work: hibernate project setup, db create tables, relationship mapping
	// 2. create instructor class (especially define field with detail objec with @OneToOne/@JoinColumn(name="foreignkey...")
	// 3. create instructor detail class
	// 4. create main app (add & delete)

	static public void main(String[] args) {
		// create session factory
		// include the entity class into the factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session
		try {
			// create instructor
			Instructor instructor = new Instructor("james", "want", "wang@gmail.com");

			// create instructor detail object
			InstructorDetail instructorDetail = new InstructorDetail("tennis", "frisco");

			// associate map 2 objects
			instructor.setInstructorDetailId(instructorDetail);

			// save instructor (cascade will be triggered to save InstructorDetails)
			session.beginTransaction();
			session.save(instructor);
			System.out.println("saving instructor/details 2 objs");
			System.out.println("saving instructor: "+ instructor.toString());
			System.out.println("saving instructorDetail: "+ instructorDetail.toString());
			
			// commit
			session.getTransaction().commit();
			System.out.println("done!");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}
}
