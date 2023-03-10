package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student") //Table name in database
public class Student {
	@Id //This is important if multiple objects are to be saved to the database at one time
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studentId")
	private int studentId;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name ="contactNum")
	private String contactNum;
	
	@Column(name = "issueType")
	private String issueType;
	
	@Column(name = "issueDetails")
	private String issueDetails;
	
	public void student() {///
		
	}
	
	//Primary constructor
	public Student(int studentId, String firstName, String lastName, String email, String contactNum, String issueType,
			String issueDetails) {
		super();
		this.studentId =studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNum = contactNum;
		this.issueType = issueType;
		this.issueDetails = issueDetails;
	}
	
	//Copy constructor
	public Student(Student student) {
		super();
		this.studentId = student.studentId;
		this.firstName = student.firstName;
		this.lastName = student.lastName;
		this.email = student.email;
		this.contactNum = student.contactNum;
		this.issueType = student.issueType;
		this.issueDetails = student.issueDetails;
	}
	
	//Default constructor
	public Student() {
		super();
		this.studentId = 0;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.contactNum = "";
		this.issueType = "";
		this.issueDetails = "";
	}
	
	//Getters and setters
	public int getId() {
		return studentId;
	}
	public void setId(int studentId) {
		this.studentId =studentId;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getIssueType() {
		return issueType;
	}
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}
	public String getIssueDetails() {
		return issueDetails;
	}
	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Students id : " +studentId + 
			"\nName : " + firstName + " " + lastName + 
			"\nEmail : " + email + 
			"\nContact number : "+ contactNum + 
			"\nType of issue: " + issueType + 
			"\nDetails of issue : " + issueDetails;
	}
}
