package samsung.java.week2.subject;

import java.io.IOException;
import java.util.Scanner;
public class SubjectsManagement {
	private Subject sbj[] = new Subject[50];
	private int i;			// i is number of subjiects
	Scanner inputString = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	Scanner pressKey = new Scanner(System.in);
	
	/** choose menu and perform methods */
	public void main(String[] args){
		int menu;
		do{
			showMenu();
			menu = inputInt.nextInt();
			switch(menu){
				case(1): appendSubject();
						enterKey();
						break;
				case(2): updateSubject();
						enterKey();
						break;
				case(3): displaySubjectInfo();
						enterKey();
						break;
				case(4): enrolStudent();
						enterKey();
						break;
				case(5): unEnrolStudent();
						enterKey();
						break;
				default: break;
			}
		}while(menu>= 1&& menu<=5);
	}
	/** initialize i=0 */
	public SubjectsManagement(){
		this.i = 0;
	}
	/** Enter to continue */
	public void enterKey(){
		System.out.println("Press Enter to continue..."); 
	    try { 
	      System.in.read(); 
	    } catch (IOException e) { 
	      // TODO Auto-generated catch block 
	      e.printStackTrace(); 
	    } 
	    pressKey.nextLine();
	}
	/** Find subject and location of subject
	 * 
	 * @param subjectID subjectID of find_subject
	 * @return if don't exist subject reurn -1 else return location of subject
	 */
	public int find(String subjectID){
		int n = -1;
		for(int j=0;j<i;j++)
			if(subjectID.compareTo(sbj[j].getSubjectID())==0){
				n = j;
				break;
			}
		return n;
	} 
	/** Enter subjectID end find subject
	 * 
	 * @return if don't exist subject reurn -1 else return location of subject
	 */
	public int enterAndFind(){
		System.out.print("Enter subject ID: ");
		String subjectID = inputString.nextLine();
		int n = find(subjectID);
		if(n==-1) System.out.println("Error! This subject ID doesn't exist");
		return n;
	}
	/** show menu */
	public static void showMenu(){
		System.out.println("Subject Management System ");
		System.out.println("-------------------------------------");
		System.out.println("1.  Append new subject ");
		System.out.println("2.  Update subject ");
		System.out.println("3.  Display the information of subject ");
		System.out.println("4.  Enrol new student ");
		System.out.println("5.  Unenrol student ");
		System.out.println("Your choice (1-5, other to quit)");
	}
	/** Append a subject */
	public void appendSubject(){
		System.out.print("Enter Subject ID: ");
		String subjectID = inputString.nextLine();
		if(find(subjectID)==-1){
			System.out.print("Enter Subject's name: ");
			String subjectName = inputString.nextLine();
			System.out.print("Enter quota: ");
			int quota = inputInt.nextInt();
			System.out.print("Enter currentEnrolment: ");
			int currentEnrolment = inputInt.nextInt();
			sbj[i] = new Subject(subjectID,subjectName,quota,currentEnrolment);
			i++;
		}
		else System.out.println("Error! This Subject ID has existed");
	}
	/** Update a subject */
	public void updateSubject(){
		int j = enterAndFind();
		if(j!=-1){
				System.out.print("Enter new Subject ID: ");
				String subjectIDNew = inputString.nextLine();
				if(find(subjectIDNew) == -1){
					System.out.print("Enter new Subject's name: ");
					String subjectName = inputString.nextLine();
					System.out.print("Enter new quota: ");
					int quota = inputInt.nextInt();
					System.out.print("Enter new currentEnrolment: ");
					int currentEnrolment = inputInt.nextInt();
					sbj[j] = new Subject(subjectIDNew,subjectName,quota,currentEnrolment);
					System.out.println("Update successfully!");
				}
					else System.out.println("Error! This Subject ID has existed");
			}
	}
	/** Display information of a subject */
	public void displaySubjectInfo(){
		int j = enterAndFind();
		if(j!=-1)sbj[j].displaySubjectInfo();
	}
	/** enrol a student of a subject */
	public void enrolStudent(){
		int j = enterAndFind();
		if(j!=-1) sbj[j].enrolStudent();
	}
	/** unenrol a stdudent of a subject */
	public void unEnrolStudent(){
		int j = enterAndFind();
		if(j!=-1) sbj[j].unEnrolStudent();
	}
}
