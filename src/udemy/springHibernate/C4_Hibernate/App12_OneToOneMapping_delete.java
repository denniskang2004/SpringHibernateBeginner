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
public class App12_OneToOneMapping_delete {

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
			session.beginTransaction();
			
			// get instructor
			Instructor instructor =session.get(Instructor.class, 2);
			System.out.println("found: "+instructor.toString());
			
			// delete
			session.delete(instructor); // cascading to delete details
			
			System.out.println("deleting instructor/details 2 objs");
			System.out.println("deleting instructor: "+ instructor.toString());
			System.out.println("deleting instructorDetails: "+ instructor.getInstructorDetailId().toString());
			
			// commit
			session.getTransaction().commit();
			System.out.println("done!");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
	}
}
