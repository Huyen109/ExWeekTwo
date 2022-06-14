package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem4 {
	public static void main (String[] args){
		double x,f,f1,fa,fb;
		final double d = 0.000001;	// delta
		// Show menu
		System.out.println("Function: f(x) = sin(2x) + x2");
		System.out.println("1. Calculate f(x) at x ");
		System.out.println("2. Calculate f’(x) at x ");
		System.out.println("3. Solve equation f(x) = 0 at [a,b] ");
		System.out.println("Press another key to quit. ");
		// Enter menu
		Scanner inputData = new Scanner(System.in);
		int menu = inputData.nextInt();
		
		switch(menu){
			case 1: // Enter x
					System.out.print("Enter x:");
					x = inputData.nextDouble();
					// Calculate f(x)
					f = Math.sin(2*x) + x*x;
					System.out.println("f(x) = " + f);
					break;
			case 2: // Enter x
					System.out.print("Enter x:");
					x = inputData.nextDouble();
					// Calculate f'(x)
					f1 = (Math.sin(2*(x + d)) + (x+d)*(x+d))/d - (Math.sin(2*x) + x*x)/d;
					System.out.println("f'(x) = " +f1);
					break;
			case 3: // Enter a,b
					System.out.print("Enter a:");
					double a = inputData.nextDouble();
					System.out.print("Enter b:");
					double b = inputData.nextDouble();
					//Find solution
					fa = Math.sin(2*a) + a*a;
					fb = Math.sin(2*b) + b*b;
					if(fa==0) System.out.println("Solution:" + a);
					if(fb==0) System.out.println("Solution:" + b);
					if((fa*fb)>0) System.out.println("No Solution");
					// bisection
					if((fa*fb)<0){
						double c,fc;
						do{
							c = (a+b)/2;
							fc = Math.sin(2*c) + c*c;
							if ((fa*fc) < 0){
								b=c;
								fb=fc;
							}
							else{
								a=c;
								fa=fc;
							}
						} while (Math.abs(b-a) <d);
						System.out.println("Solution:" + c);
					}
					break;
			default : break;
		}
	}
}
