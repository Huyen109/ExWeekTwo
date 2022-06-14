package samsung.java.week3.shape;

public class Round {
	private float radius;
	public final float pi = 3.14f;
	/** constructor method */
	public Round(){
		this.radius = 0;
	}
	/** constructor method */
	public Round(float initRadius){
		this.radius = initRadius;
	} 
	/** get radius */
	public float getRadius() {
		return radius;
	}
	/** set radius */
	public void setRadius(float radius) {
		this.radius = radius;
	}
	/** calculate diameter */
	public float calculateDiameter(){
		float diameter;
		diameter = radius*2;
		return diameter;
	}
	/** calculate Circumference */
	public float calculateCircumference(){
		float circumference;
		circumference = 2*pi*radius;
		return circumference;
	}
	/** calculate area */
	public float calculateArea(){
		float area;
		area = pi*radius*radius;
		return area;
	}
}
