package samsung.java.week3.shape;

public class TruncateCone {
	private Round R1,R2;
	private float h;
	/** constructor method */
	public TruncateCone(Round R1, Round R2, float h){
		this.R1 = R1;
		this.R2 = R2;
		this.h = h;
	}
	/** calculate Surrounding Area */
	public float calculateSurroundingArea(){
		float l = (float) Math.sqrt((R1.getRadius()-R2.getRadius())*(R1.getRadius()-R2.getRadius()) + h*h);
		float SA = 3.14f*(R1.getRadius() + R2.getRadius())*l;
		return SA;
	}
	/** calculate Total Area */
	public float calculateTotalArea(){
		float TA = calculateSurroundingArea() + R1.calculateArea() + R2.calculateArea();
		return TA;
	}
	/** calculate volume */
	public float calculateVolume(){
		float volume = (float) (h/3*(R1.calculateArea() + R2.calculateArea() + Math.sqrt(R1.calculateArea()*R2.calculateArea())));
		return volume;
	}
}
