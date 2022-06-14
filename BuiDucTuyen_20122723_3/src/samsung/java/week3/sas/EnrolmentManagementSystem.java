package samsung.java.week3.sas;

import java.io.IOException;
import java.util.Scanner;

public class EnrolmentManagementSystem {

	private Subject S[] = new Subject[20];
	private SpecialSubject SS[] = new SpecialSubject[20];
	private int y,z;
	Scanner inputString = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	Scanner inputFloat = new Scanner(System.in);
	Scanner pressKey = new Scanner(System.in);
	/** constructor method */
	public EnrolmentManagementSystem(){
		this.y = 0;
		this.z = 0;
	}
	/** choose menu and perform methods */
	public void main(String[] args){
		int menu;
		do{
			showMenu();
			menu = inputInt.nextInt();
			switch(menu){
				case(1): enrolNomalSubject();
						enterKey();
						break;
				case(2): enrolSpecialSubject();
						enterKey();
						break;
				case(3): unenrolSubject();
						enterKey();
						break;
				case(4): displayFeeInformation();
						enterKey();
						break;
				default: break;
			}
		}while(menu>= 1&& menu<=4);
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
		System.out.println("Enrolment Management System\n\r------------------------------------- ");
		System.out.println("1.  Enrol a normal subject ");
		System.out.println("2.  Enrol a special subject");
		System.out.println("3.  Unenrol a subject ");
		System.out.println("4.  Display fee information ");
		System.out.println("Your choice (1-4, other to quit)");
	}
	/** Find nomal subject and location of nomal subject
	 * 
	 * @param subjectID subjectID of find_subject
	 * @return if don't exist nomal subject reurn -1 else return location of nomal subject
	 */
	public int findS(String subjectID){
		int n = -1;
		for(int j=0;j<y;j++)
			if(subjectID.compareTo(S[j].getID())==0){
				n = j;
				break;
			}
		return n;
	} 
	/** Find special subject and location of special subject
	 * 
	 * @param subjectID subjectID of find_subject
	 * @return if don't exist subject reurn -1 else return location of subject
	 */
	public int findSS(String subjectID){
		int n = -1;
		for(int j=0;j<z;j++)
			if(subjectID.compareTo(SS[j].getID())==0){
				n = j;
				break;
			}
		return n;
	} 
	/** enrol Nomal Subject */
	public void enrolNomalSubject(){
		int choose =1;
		while(choose==1){
			System.out.print("Enter Subject ID: ");
			String subjectID = inputString.nextLine();
			if(findS(subjectID)==-1&&findSS(subjectID)==-1){
				System.out.print("Enter Subject's name: ");
				String subjectName = inputString.nextLine();
				System.out.print("Enter no of subject: ");
				float no = inputFloat.nextFloat();
				System.out.print("Enter no of practise: ");
				float noPractise = inputFloat.nextFloat();
				S[y] = new Subject(subjectID,subjectName,no,noPractise);
				y++;
			}
			else System.out.println("Error! This Subject ID has existed");
			System.out.print("Do you want enrol  continuouss subject(yes:enter 1, no enter other number)");
			choose = inputInt.nextInt();
		} 
	}
	/** enrol special Subject */
	public void enrolSpecialSubject(){
		int choose =1;
		while(choose==1){
			System.out.print("Enter Subject ID: ");
			String subjectID = inputString.nextLine();
			if(findSS(subjectID)==-1&&findS(subjectID)==-1){
				System.out.print("Enter Subject's name: ");
				String subjectName = inputString.nextLine();
				System.out.print("Enter Subject's programme: ");
				String programme = inputString.nextLine();
				System.out.print("Enter no of subject: ");
				float no = inputFloat.nextFloat();
				System.out.print("Enter no of practise: ");
				float noPractise = inputFloat.nextFloat();
				SS[z] = new SpecialSubject(programme,subjectID,subjectName,no,noPractise);
				z++;
			}
			else System.out.println("Error! This Subject ID has existed");
			System.out.print("Do you want enrol  continuouss subject(yes:enter 1, no enter other number)");
			choose = inputInt.nextInt();
		} 
	}
	/** unenrol Subject */
	public void unenrolSubject(){
		int choose =1;
		while(choose==1){
			System.out.print("Enter Subject ID: ");
			String subjectID = inputString.nextLine();
			if(findS(subjectID)!=-1){
				if(findS(subjectID)!=y)
				for(int i=findS(subjectID);i<y-1;i++) S[i]= S[i+1];
				y--;
			}
			else if(findSS(subjectID)!=-1){
					if(findSS(subjectID)!=z)
					for(int i=findSS(subjectID);i<z-1;i++) SS[i]= SS[i+1];
					z--;
			}
				else System.out.println("Error! This Subject ID no existed");
			System.out.print("Do you want unenrol  continuouss subject(yes:enter 1, no enter other number)");
			choose = inputInt.nextInt();
		} 
	}
	/** display informations */
	public void displayFeeInformation(){
		float total =0;
		System.out.println("FEE INFORMATION \r\n*****\r\nNormal Subjects ");
		for(int i=0;i<y;i++){
			total += S[i].getFee();
			System.out.println(S[i].getEnrolmentLine());
		}
		System.out.println("-----\r\nTotal: "+total+"\r\n*****\r\nSpecial Subjects");
		total =0;
		for(int i=0;i<z;i++){
			total += SS[i].getFee();
			System.out.println(SS[i].getEnrolmentLine());
		}
		System.out.println("-----\r\nTotal: "+total);
	}
}
