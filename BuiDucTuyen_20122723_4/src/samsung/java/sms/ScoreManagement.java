package samsung.java.sms;

import java.io.IOException;
import java.util.Scanner;

public class ScoreManagement {
	private ScoreBoard SB[] = new ScoreBoard[40];
	private int x =0;
	Scanner inputString = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	Scanner inputFloat = new Scanner(System.in);
	Scanner pressKey = new Scanner(System.in);
	
	/** choose menu and perform methods */
	public void main(String[] args){
		int menu;
		do{
			showMenu();
			menu = inputInt.nextInt();
			switch(menu){
				case(1):addScoreBoard ();
						enterKey();
						break;
				case(2): addMarkStudent();
						enterKey();
						break;
				case(3): removeMarkStudent();
						enterKey();
						break;
				case(4): seachMark();
						enterKey();
						break;
				case(5): display();
						enterKey();
						break;
				default: break;
			}
		}while(menu>= 1&& menu<=5);
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
	/** show menu */
	public static void showMenu(){
		System.out.println("Learning Management System \n\r------------------------------------- ");
		System.out.println("1.  Add a new score board  ");
		System.out.println("2.  Add score");
		System.out.println("3.  Remove score  ");
		System.out.println("4.  Search score ");
		System.out.println("5.  Display score board and score report");
		System.out.println("Your choice (1-5, other to quit)");
	}
	/** Find subject and location of subject
	 * 
	 * @param subjectID subject ID of find_subject
	 * @return if don't exist subject reurn -1 else return location of subject
	 */
	public int findSubjectID(String subjectID){
		int n = -1;
		for(int j=0;j< x;j++)
			if(subjectID.compareTo(SB[j].getSbt().getID())==0){
				n = j;
				break;
			}
		return n;
	} 
	
	/** Find subject and location of subject
	 * 
	 * @param ID SemesterID of find_subject
	 * @return if don't exist subject reurn -2 else return location of subject
	 */
	public int findSemesterID(int ID){
		int n = -2;
		for(int j=0;j< x;j++)
			if(ID == SB[j].getSemesterID()){
				n = j;
				break;
			}
		return n;
	} 
	/** add score board */
	public void addScoreBoard(){
		String choose = "Y";
		while(choose.compareTo("Y")==0){
			System.out.print("Enter Subject ID: ");
			String ID = inputString.nextLine();
			System.out.print("Enter semesterID: ");
			int semesterID = inputInt.nextInt();
			if(findSubjectID(ID)==-1&&findSemesterID(semesterID)==-2){
				System.out.print("Enter Subject's name: ");
				String name = inputString.nextLine();
				System.out.print("Enter coefficient Process: ");
				float coefficientProcess = inputFloat.nextFloat();
				System.out.print("Enter no of Student: ");
				int noStudent = inputInt.nextInt();
				SB[x] = new ScoreBoard( ID, name, coefficientProcess, semesterID, noStudent);
				for(int i=0; i< noStudent; i++){
					System.out.println("Enter informations of sthudent "+(i+1));
					SB[x].addMark(i);
				}
				SB[x].update();
				SB[x].setReport();
				x++;
			}
			else System.out.println("Error! This Subject  has existed");
			System.out.print("Do you want continue add score board(yes: enter Y else enter other key): ");
			choose = inputString.nextLine();
		}
	}
	
	/** add score */
	public void addMarkStudent(){
		String choose = "Y";
		while(choose.compareTo("Y")==0){
			System.out.print("Enter Subject ID: ");
			String ID = inputString.nextLine();
			System.out.print("Enter semesterID: ");
			int semesterID = inputInt.nextInt();
			if(findSubjectID(ID)==findSemesterID(semesterID)){
				SB[findSubjectID(ID)].addNewMark();
				SB[findSubjectID(ID)].update();
			}
			else System.out.println("Error! This subject doesn't exist");
			System.out.print("Do you want continue add score board(yes: enter Y else enter other key): ");
			choose = inputString.nextLine();
		}
	}
	
	/** remove score */
	public void removeMarkStudent(){
		String choose = "Y";
		while(choose.compareTo("Y")==0){
			System.out.print("Enter Subject ID: ");
			String ID = inputString.nextLine();
			System.out.print("Enter semesterID: ");
			int semesterID = inputInt.nextInt();
			if(findSubjectID(ID)==findSemesterID(semesterID)){
				SB[findSubjectID(ID)].removeMark();
				SB[findSubjectID(ID)].update();
			}
			else System.out.println("Error! This subject doesn't exist");
			System.out.print("Do you want continue add score board(yes: enter Y else enter other key): ");
			choose = inputString.nextLine();
		}
	}
	
	/** seach core of student*/
	public void seachMark(){
		String choose = "Y";
		while(choose.compareTo("Y")==0){
			System.out.print("Enter Subject ID: ");
			String ID = inputString.nextLine();
			System.out.print("Enter semesterID: ");
			int semesterID = inputInt.nextInt();
			if(findSubjectID(ID)==findSemesterID(semesterID)){
				System.out.print("Enter student ID: ");
				int studentID = inputInt.nextInt();
				int d = SB[findSubjectID(ID)].find(studentID);
				if( d!=-1){
					System.out.println(SB[findSubjectID(ID)].SS[d].getMarkLine(SB[findSubjectID(ID)].getSbt().getCoefficientProcess()));
				}
				else System.out.println("Error! This name ID doesn't exist");
			}
			else System.out.println("Error! This subject doesn't exist");
			System.out.print("Do you want continue add score board(yes: enter Y else enter other key): ");
			choose = inputString.nextLine();
		}
	}
	/**Display score board and score report */
	public void display(){
		System.out.print("Enter Subject ID: ");
		String ID = inputString.nextLine();
		System.out.print("Enter semesterID: ");
		int semesterID = inputInt.nextInt();
		if(findSubjectID(ID)==findSemesterID(semesterID)){
			SB[findSubjectID(ID)].display();
		}
		else System.out.println("Error! This subject ID or semesterID doesn't exist");
	}
}
