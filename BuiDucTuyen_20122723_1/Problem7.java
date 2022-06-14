package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem7 {
	public static void main(String[] args){
		// Enter n
		int n=-1;
		Scanner inputData = new Scanner(System.in);
		while(n<0||n>100){
			System.out.print("Enter n: ");
			n = inputData.nextInt();
			if (n<0||n>100) System.out.println("Enter error "); // 0<n<100
		}
		// Enter series of number
		double A[]= new double[100];
		System.out.println("Enter series of number: ");
		for(int i=0;i<n;i++) A[i] = inputData.nextDouble();
		// arrange series of number
		double d;
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				if(A[i]<A[j]){
					d = A[i];
					A[i] = A[j];
					A[j] =d;
				}
			}
		}
		// Show series of number
		for(int i=0;i<n;i++) System.out.print(" "+A[i]);
	}
}
