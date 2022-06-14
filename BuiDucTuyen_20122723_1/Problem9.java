package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem9 {
	public static void main(String[] args){
		// Enter number of students
		System.out.print("Enter number of students:");
		Scanner inputData = new Scanner(System.in);
		int n = inputData.nextInt();	// n is number of student
		// Enter student's name
		String[] S = new String[n];		// S is student's name
		Scanner inputData2 = new Scanner(System.in);
		for(int i=0;i<n;i++){
			System.out.print("Student "+(i+1)+": ");
			S[i] = inputData2.nextLine();
		}
		// Find name
		System.out.print("Find name: ");
		String find = inputData2.nextLine();
		boolean compare = false;
		for(int i=0;i<n;i++) if(find.compareTo(S[i])==0){
			compare = true;
			break;
		}
		if(compare) System.out.println("This name is in the list");
		else System.out.println("This name isn't in the list");
	}
}
