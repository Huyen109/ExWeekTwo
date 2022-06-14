package samsung.java.week3.sas;

public class Subject implements ISubject {
	private String ID;
	private String name;
	private float no;
	private float noPractise;
	/** constructor method */
	public Subject(String ID,String name, float no, float noPractise){
		this.ID = ID;
		this.name = name;
		this.no = no;
		this.noPractise = noPractise;
	}
	@Override
	public float getFee() {
		float fee = (no + noPractise)*150000;
		return fee;
	}

	@Override
	public String getEnrolmentLine() {
		String enrolmentLine=null;
		char[] arrayName = name.toCharArray();
		String name20;
		if(name.length()<=20)  name20 = String.valueOf(arrayName);
		else name20 = String.valueOf(arrayName, 0, 20);
		String stringNoFee = String.valueOf(no + noPractise);
		String stringFee = String.valueOf(getFee());
		enrolmentLine = ID;
		enrolmentLine = enrolmentLine.concat("  "+name20+"  "+stringNoFee+"  "+stringFee);
		return enrolmentLine;
	}
// getter and setter
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public float getNo() {
		return no;
	}

	public void setNo(float no) {
		this.no = no;
	}

	public float getNoPractise() {
		return noPractise;
	}

	public void setNoPractise(float noPractise) {
		this.noPractise = noPractise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
