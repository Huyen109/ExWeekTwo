package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem6 {
	public static void main(String[] args) {
		int n=-1,f2;
		int f0=1;
		int f1=1;
		// Enter n
		Scanner inputData = new Scanner(System.in);
		while(n<0){
			System.out.println("Enter n: ");
			n = inputData.nextInt();
			if (n<0) System.out.println(" Enter error ");
		}
		// Show Fibonacci
		if(n==0) System.out.print("1");
		else {
			System.out.print("1 1");
			for (int i = 2; i <=n; i++) {
				f2=f0+f1;
				System.out.print(" "+f2);
				f0=f1;
				f1=f2;
			}
		}
	}
}
