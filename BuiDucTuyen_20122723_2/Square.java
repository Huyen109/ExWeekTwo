package samsung.java.week2.square;

public class Square {
	private float length;
	/** set length value */
	public void setLength(int initLength){
		this.length = initLength;
	}
	/** Display length */
	public void displayLength(){
		System.out.println("length: "+length);
	}
	/** calculate and display perimeter */
	public void displayPerimeter(){
		float perimeter = length*4;
		System.out.println("perimeter: "+perimeter);
	}
	/** calculate and display area */
	public void displayArea(){
		float area = length*length;
		System.out.println("area: "+area);
	}
	/** display all */
	public void displayAll(){
		displayLength();
		displayPerimeter();
		displayArea();
	}
}
