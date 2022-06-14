package samsung.java.week3.shape;

import java.util.Scanner;

public class Test {

	public static void main(String[] args){
		// enter cone
		Scanner inputFloat = new Scanner(System.in);
		System.out.print("Enter radius of cone: ");
		float r = inputFloat.nextFloat();
		Round R = new Round(r);
		System.out.print("Enter hight of cone: ");
		float h = inputFloat.nextFloat();
		Cone c = new Cone(R,h);
		System.out.println("Surrounding Area of cone: "+c.calculateSurroundingArea());
		System.out.println("Total Area of cone: "+c.calculateTotalArea());
		System.out.println("Volune of cone: "+c.calculateVolume());
		
		//enter truncatecone
		System.out.print("Enter radius1 of truncatecone: ");
		float r1 = inputFloat.nextFloat();
		Round R1 = new Round(r1);
		System.out.print("Enter radius2 of truncatecone: ");
		float r2 = inputFloat.nextFloat();
		Round R2 = new Round(r1);
		System.out.print("Enter hight of truncatecone: ");
		float h2 = inputFloat.nextFloat();
		TruncateCone t = new TruncateCone(R1,R2,h2);
		System.out.println("Surrounding Area of cone: "+t.calculateSurroundingArea());
		System.out.println("Total Area of cone: "+t.calculateTotalArea());
		System.out.println("Volune of cone: "+t.calculateVolume());
	}
}
