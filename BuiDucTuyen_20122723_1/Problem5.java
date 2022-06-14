package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem5 {
	public static void main(String[] args){
		// Enter n
		int n=-1;
		Scanner inputData = new Scanner(System.in);
		while(n<0||n>100){
			System.out.println("Enter n: ");
			n = inputData.nextInt();
			if (n<0||n>100) System.out.println("Enter error "); //min=0 max=100
		}
		int i,j;
		int A[][]= new int[100][100];
		int B[][]= new int[100][100];
		// Show pascal triangle
	    for(i = 0;i < n;i++){
	        for(j = 0; j <= i; j++){
	            if(i == j || j == 0){
	                A[i][j] = 1;
	                System.out.print(" "+A[i][j]);
	            }
	            else{
	                A[i][j] = A[i-1][j-1] + A[i-1][j];
	                System.out.print(" "+A[i][j]);
	            }
	        }
	        System.out.print("\r\n");
	    }
	}
}
