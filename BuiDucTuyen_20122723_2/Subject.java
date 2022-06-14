package samsung.java.week2.subject;

public class Subject {
	private String subjectID;
	private String subjectName;
	private int quota;
	private int currentEnrolment;
	/** The default constructor */
	public Subject(){
		this.quota = 0;
	}
	//Declare other methods..
	/** Constructs a newly created Subject object by    
	assigning initial values for attributes
	*@param initID : the ID of subject
	*@param initName : the name of subject
	*@param initQuota : the quota of subject
	*@param initCurrentEnrolment :  the initial number of 
	students enrolling
	*/
	public Subject(String initID, String initName, int 
	initQuota, int initCurrentEnrolment){
		this.subjectID = new String(initID);
		this.subjectName = new String (initName);
		this.quota = initQuota;
		this.currentEnrolment = initCurrentEnrolment;
	}
	/** Enrols a student into course*/
	public void enrolStudent(){
		System.out.print("Enrolling student… ");
		if (currentEnrolment < quota){ 
			++currentEnrolment;
			System.out.println("Student enrolled in " + subjectName);
		}
		else
		System.out.println("Quota reached, enrolment failed");
	}
	/** Cancels an enrolment*/
	public void unEnrolStudent(){
		System.out.print("Un-enrolling student… ");
		if (currentEnrolment <= 0) 
			System.out.println("No students to un-enrol");
		else{
			--currentEnrolment;
			System.out.println("Student un-enrolled from " + subjectName);
		}
	}
	/** Displays the information of the course*/
	public void displaySubjectInfo(){
		System.out.println("Subject ID: " + subjectID);
		System.out.println("Subject name: " + subjectName);
		System.out.println("Quota: " + quota);
		System.out.println("Currently enrolled: " + currentEnrolment);
		//	int availablePlaces = quota – currentEnrolment;
		System.out.println("Can accept " + (quota - currentEnrolment) + " more students");
	}
	/** get subject ID */
	public String getSubjectID(){
		return subjectID;
	}
	/** get subject name */
	public String getSubjectName(){
		return subjectName;
	}
	/** set subject ID */
	public void setSubjectID(String inSubjectID){
		subjectID = inSubjectID;
	}
	/** set subject's name */
	public void setSubjectName(String inSubjectName){
		subjectName = inSubjectName;
	}
	/** set quota */
	public void setQuota(int inQuota){
		quota = inQuota;
	}
	/** set currentEnrolment */
	public void setCurrentEnrolment(int inCurrentEnrolment){
		currentEnrolment = inCurrentEnrolment;
	}
}
