package udemy.springHibernate.C4_Hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	// annotate class
	// define fields
	// annotate fields
	// create constructors
	// create getter/setters
	// toString override
	// **create OneToOne relationship
	// ATTN: all imports are from javax.persistence.
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // how id is generated
	@Column(name = "id") // primary key! map to database column name "id"
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")	//uni-directional
	private InstructorDetail instructorDetail;
	
	@OneToMany(
			fetch=FetchType.LAZY,
			mappedBy="instructor", // refer to instructor field of course class
			cascade= {
					CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Course> courses;
	
	public void addCourse(Course newCourse) {
		courses.add(newCourse);
		newCourse.setInstructor(this); //map this course with current instructor
	}
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public Instructor() {
		// TODO Auto-generated constructor stub
		courses = new ArrayList<>();
	}

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
		courses = new ArrayList<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", instructorDetailId="
				+ instructorDetail + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InstructorDetail getInstructorDetailId() {
		return instructorDetail;
	}

	public void setInstructorDetailId(InstructorDetail instructorDetailId) {
		this.instructorDetail = instructorDetailId;
	}
	
	
}
