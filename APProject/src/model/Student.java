package model;


public class Student {
	private String id;
	private String fName;
	private String lName;
	private String email;
	private String contactNum;
	private String issueType;
	private String issueDetails;
	
	//Primary constructor
	public Student(String id, String fName, String lName, String email, String contactNum, String issueType,
			String issueDetails) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.contactNum = contactNum;
		this.issueType = issueType;
		this.issueDetails = issueDetails;
	}
	//Copy constructor
	public Student(Student student) {
		super();
		this.id = student.id;
		this.fName = student.fName;
		this.lName = student.lName;
		this.email = student.email;
		this.contactNum = student.contactNum;
		this.issueType = student.issueType;
		this.issueDetails = student.issueDetails;
	}
	
	//Default constructor
	public Student() {
		super();
		this.id = "";
		this.fName = "";
		this.lName = "";
		this.email = "";
		this.contactNum = "";
		this.issueType = "";
		this.issueDetails = "";
	}
	
	//Getters and setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
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
		return "Student id : " + id + 
			"\nName : " + fName + " " + lName + 
			"\nEmail : " + email + 
			"\nContact number : "+ contactNum + 
			"\nType of issue: " + issueType + 
			"\nDetails of issue : " + issueDetails;
	}
}
