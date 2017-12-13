package udemy.springHibernate.C4_Hibernate;

public class App18_ManyToMany {

	// Many to Many achieved by "Joined Table"
	
	// JOined table: courseId, studentId
	
	// Course class: students field, @ManyToMay @JoinTable
	
	// Student class: courses field
	// @ManyToMany
	// @JoinTable, name='student_course'
	// joinedColumn = @JoinColumn(name='studnet_id')
	// inverseJoinColumns = @JoinColumn(name='course_id')
}
