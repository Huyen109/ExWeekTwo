package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem2 {
	public static void main (String[] args){
		double f;
		final double d = 0.000001;	// delta
		// Enter x
		System.out.print("Enter x:");
		Scanner inputData = new Scanner(System.in);
		double x = inputData.nextDouble();
		// Calculate f'(x)
		f = (Math.tan(2*(x + d)) - (x+d) + 1)/d - (Math.tan(2*x) - x + 1)/d;
		System.out.print("f'(x) = " +f);
	}
}
