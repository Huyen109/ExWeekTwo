package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem1 {
	public static void main (String[] args){
		double f,g;
		// Enter x
		System.out.print("Enter x:");
		Scanner inputData = new Scanner(System.in);
		double x = inputData.nextDouble();
		// Enter y
		System.out.print("Enter y:");
		double y = inputData.nextDouble();
		// Calculate f(x)
		f = (Math.log(x*x+1) + Math.sqrt(x*x*x*x + 1))/(x*x - x +1);
		System.out.println("f(x) = " + f);
		// Calculate g(x,y)
		g = Math.cos(2*x) + y*y - y + 1;
		System.out.println("g(x,y) = " + g);
	}
}
