package samsung.java.hw1;

import java.util.Scanner;

public class Problem10 {
	public static void main(String[] args){
		System.out.print("Enter number of submarines:");
		Scanner inputData = new Scanner(System.in);
		int n = inputData.nextInt(); // n is number of submaries
		int A[] = new int[n]; // Viet Nam or not
		int X[] = new int[n]; // x
		int Y[] = new int[n]; // y
		// Enter Submarines
		for(int i=0;i<n;i++){
			System.out.println("Submarines "+(i+1));
			System.out.print("If submarine of Viet Nam, enter 1 else enter -1:");
			A[i] = inputData.nextInt();
			System.out.print("Enter x:");
			X[i] = inputData.nextInt();
			System.out.print("Enter y:");
			Y[i] = inputData.nextInt();
		}
		// Show Coordinates of the submarine's not VietNam in the range of rocket
		System.out.println("Coordinates of the submarine's not VietNam in the range of rocket:");
		for(int i=0;i<n;i++){
			if(A[i]==-1&&Math.sqrt(X[i]*X[i]+Y[i]*Y[i])<=150)
				System.out.println("("+X[i]+";"+Y[i]+")");
		}
	}
}
