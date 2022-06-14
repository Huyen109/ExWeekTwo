package samsung.java.sms;

public class StudentScore {
	private String lastName;
	private String name;
	private int ID;
	private float markProcess;
	private float markFinal;
	
	public StudentScore(){
		this.markProcess =0;
		this.markFinal =0;
	}
	
	
	/** Constructs a newly created student core object by    
	*@param lastName : the last name of student
	*@param Name : the name of student
	*@param ID : the ID of student
	*@param markProcess : mark process of student
	*@param markFinal : mark final of student
	*/
	public StudentScore(String lastName, String name, int ID, float markProcess, float markFinal){
		this.lastName = lastName;
		this.name = name;
		this.ID = ID;
		this.markProcess = markProcess;
		this.markFinal = markFinal;
		
	}
	
	/** get total mark*/
	public float getTotalMark(float coefficient){
		float totalMark = (coefficient*markProcess + (100-coefficient)*markFinal)/100;
		return totalMark;
	}
	
	/** get char mark*/
	public char getMark(float coefficient){
		char charMark;
		float mark = (coefficient*markProcess + (100-coefficient)*markFinal)/100;
		if(mark>=0 && mark<4) charMark = 'F';
			else if(mark<5.5) charMark = 'D';
				else if(mark<7) charMark = 'B';
					else charMark = 'A';
		return charMark;
	}
	
	/** get mark line*/
	public String getMarkLine(float coefficient){
		String markLine = "S|";
		markLine = markLine.concat(String.valueOf(ID)+"|"+lastName);
		for(int i=0; i<(20-lastName.length()); i++) markLine = markLine.concat(" ");
		markLine = markLine.concat("|"+ name);
		for(int i=0; i<(7-name.length()); i++) markLine = markLine.concat(" ");
		markLine = markLine.concat("|"+ String.valueOf(markProcess)+"|"+String.valueOf(markFinal)+"|"+getMark(coefficient)+"|");
		return markLine;
		
	}

	/**
	 * @return the markFinal
	 */
	public float getMarkFinal() {
		return markFinal;
	}

	/**
	 * @param markFinal the markFinal to set
	 */
	public void setMarkFinal(float markFinal) {
		this.markFinal = markFinal;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the markProcess
	 */
	public float getMarkProcess() {
		return markProcess;
	}

	/**
	 * @param markProcess the markProcess to set
	 */
	public void setMarkProcess(float markProcess) {
		this.markProcess = markProcess;
	}
	

}
