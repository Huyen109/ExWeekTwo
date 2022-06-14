package samsung.java.hw1;
import java.io.*;
import java.util.Scanner;
public class Problem8 {
	public static void main(String[] args){
		// Enter String
		System.out.print("Enter String: ");
		String s ;
		Scanner inputData = new Scanner(System.in);
		s = inputData.nextLine();
		s.trim();
		// Number of word
		int numberWord=0; // number of words
		for(int i=0;i<s.length();i++){
			int c = s.charAt(i);
			if(c==32) numberWord ++; // equal vs space
		}
		numberWord ++; //nmber of word = number of space + 1
		System.out.println("Number of words:"+numberWord);
		// times
		int t=1; 	// t is times
		int done=1; // done is variable check
		for(int i=0;i<s.length();i++){
			t=1;
			done=1;
			// check repetition
			if(i>0)
				for(int x=i-1;x>=0;x--){ 
					if(s.charAt(i)==s.charAt(x)){
						done=0;
					}
				}
			// count the times
			if(done==1&&(int)s.charAt(i)!=32){
				for(int j=i+1;j<s.length();j++){
					if(s.charAt(j)==s.charAt(i)) t++;
				}
				System.out.println(s.charAt(i)+" "+t+" times");
			}
		}
	}
}