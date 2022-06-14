package samsung.java.week2.square;

import java.util.Scanner;

public class TestSquare {
	/** test methol of class Square */
	public static void main(String[] args){
		// Enter length of square
		System.out.print("Enter length: ");
		Scanner inputData = new Scanner(System.in);
		int initLength = inputData.nextInt();
		// intial mySquare
		Square mySquare = new Square();
		// Set length value
		mySquare.setLength(initLength);
		// display all
		mySquare.displayLength();
		mySquare.displayPerimeter();
		mySquare.displayArea();
		mySquare.displayAll();
	}
}
