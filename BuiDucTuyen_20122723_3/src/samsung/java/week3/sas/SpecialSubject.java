package samsung.java.week3.sas;

public class SpecialSubject extends Subject implements ISpecialSubject {

	String programme;
	/** constructor method */
	public SpecialSubject(String programme, String ID, String name, float no, float noPractise) {
		super(ID, name, no, noPractise);
		this.programme = programme;
	}

	@Override
	public float getSpecialFee() {
		float specialFee =0;
		switch(programme){
			case "SIE": specialFee = getNo()*50000; break;
			case "HEDSPI": specialFee = getNo()*20000; break;
			case "ICT": specialFee = getNo()*30000; break;
			default: break;
		}
		return specialFee;
	}
	/** get fee */
	public float getFee(){
		float Fee = super.getFee() + getSpecialFee();
		return Fee;
	}
	/** get EnrolmentLine */
	public String getEnrolmentLine() {
		String enrolmentLine;
		char[] arrayName = getName().toCharArray();
		String name20;
		if(getName().length()<=20)  name20 = String.valueOf(arrayName);
		else name20 = String.valueOf(arrayName, 0, 20);
		String stringNoFee = String.valueOf(getNo() + getNoPractise());
		String stringFee = String.valueOf(getFee());
		String stringSpecialFee = String.valueOf(getSpecialFee());
		enrolmentLine = getID();
		enrolmentLine = enrolmentLine.concat("  "+name20+"  "+programme+"  "+stringNoFee+"  "+stringFee+"  "+stringSpecialFee);
		return enrolmentLine;
	}
}
