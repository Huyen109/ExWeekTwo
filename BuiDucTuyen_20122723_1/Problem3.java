package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem3 {
	public static void main (String[] args){
		int x=-1; // x is electricity number
		Scanner inputData = new Scanner(System.in);
		// Enter electricity number
		while(x<0){
			System.out.print("Enter electricity number: ");
			x = inputData.nextInt();
			if (x<0) System.out.println("Enter error ");
		}
		
		// Calculate electricity rates
		double y; // y is electricity rates
		if(x>150)
			y = 25*1000 + 50*1250 + 75*1800 + (x-150)*2500;
		else if(x>75)	// 75=<x<150
				y =25*1000 + 50*1250 + (x-75)*1800;
			else if(x>25)	//25=<x<75
					y =25*1000 + (x-25)*1250;
				else	// 0=<x<25
					y = x*1000;
		System.out.println("Electricity rates: "+y);
		
	}
	

}
