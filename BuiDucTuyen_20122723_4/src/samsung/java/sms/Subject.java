package samsung.java.sms;

public class Subject {
	private String ID;
	private String name;
	private float coefficientProcess;
	private float coefficientFinal;
	
	/** Constructs a newly subject object by    
	*@param ID : the ID subject
	*@param Name : the name of subject
	*@param coefficientProcess : the coefficientProcess of subject
	*/
	public Subject(String ID,String name, float coefficientProcess){
		this.ID = ID;
		this.name = name;
		this.coefficientProcess = coefficientProcess;
		this.coefficientFinal = 100 - coefficientProcess;
	}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the coefficientProcess
	 */
	public float getCoefficientProcess() {
		return coefficientProcess;
	}
	/**
	 * @param coefficientProcess the coefficientProcess to set
	 */
	public void setCoefficientProcess(float coefficientProcess) {
		this.coefficientProcess = coefficientProcess;
	}
	/**
	 * @return the coefficientFinal
	 */
	public float getCoefficientFinal() {
		return coefficientFinal;
	}
	/**
	 * @param coefficientFinal the coefficientFinal to set
	 */
	public void setCoefficientFinal(float coefficientFinal) {
		this.coefficientFinal = coefficientFinal;
	}
}
