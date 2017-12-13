package udemy.springHibernate.C4_Hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	// annotate class 
	// define fields
	// annotate fields
	// create constructors
	// create getter/setters
	// toString override
	
	
	// **create bi-directional relation: refer instructor
	// no need to change the DB schema 
	// add field 
	// add @OneToOne
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hobby")
	private String hobby;
	
	@Column(name="homeaddress")
	private String homeAddress;

	// create bi-directional mapping
	// specify "instructorDetail" field in Instructor class 
	// cascade everything except deletion
	@OneToOne(mappedBy="instructorDetail", 
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}) 
	private Instructor instructor;
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", hobby=" + hobby + ", homeAddress=" + homeAddress + "]";
	}
	
	public InstructorDetail() {
	}

	public InstructorDetail( String hobby, String homeAddress) {
		super();
		this.hobby = hobby;
		this.homeAddress = homeAddress;
	}
	
}
