package samsung.java.sms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ScoreBoard {
	private Subject Sbt;
	public StudentScore SS[] = new StudentScore[40];
	private int semesterID;
	private int noStudent =0;
	Scanner inputString = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	
	/** Constructs a newly created Subject object by    
	assigning initial values for attributes
	*@param ID : the ID of subject
	*@param Name : the name of subject
	*@param coefficientProcess : the coefficientProcess of subject
	*@param semesterID :  the semester ID number of students enrolling
	*@param noStudent :  no Student
	*/
	public ScoreBoard(String ID,String name, float coefficientProcess, int semesterID, int noStudent){
		Sbt = new Subject( ID, name, coefficientProcess);
		this.semesterID = semesterID;
		this.noStudent = noStudent;
		File fileScore =new File("D:"+Sbt.getName()+"_"+Sbt.getID()+".txt");
		if(fileScore.exists()){
			try(BufferedReader reader = new BufferedReader(new FileReader("D:"+Sbt.getID()+"_"+ semesterID+".txt"))){
					String line;
					StringTokenizer readData;
					for (int i=0;i<5;i++){
						line = reader.readLine();
							readData = new StringTokenizer(line,"|");
							String s = readData.nextToken();
							s = readData.nextToken();
							switch(i){
							case 0: Sbt.setID(s); break;
							case 1: Sbt.setName(s); break;
							case 2: Sbt.setCoefficientProcess(Float.parseFloat(s));
									Sbt.setCoefficientFinal(100-Float.parseFloat(s));
									break;
							case 3: semesterID = Integer.parseInt(s); break;
							case 4: noStudent = Integer.parseInt(s); break;
							}
					}

			}
	
					catch(FileNotFoundException e){
					System.out.println(e.getMessage());
					}
					catch(IOException e){
					System.out.println(e.getMessage());
					}
		} else
			try {
				fileScore.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	/** Find subject and location of subject
	 * 
	 * @param ID subjectID of find_subject
	 * @return if don't exist subject reurn -1 else return location of subject
	 */
	public int find(int ID){
		int n = -1;
		for(int j=0;j<noStudent;j++)
			if(ID == SS[j].getID()){
				n = j;
				break;
			}
		return n;
	} 
	
	/** add mark of student */
	public void addMark(int i){
		System.out.print("Enter StudentID: ");
		int ID = inputInt.nextInt();
		System.out.print("Enter lastname of student: ");
		String lastName = inputString.nextLine();
		System.out.print("Enter fistname of student: ");
		String name = inputString.nextLine();
		System.out.print("Enter mark process: ");
		int markProcess = inputInt.nextInt();
		System.out.print("Enter mark final: ");
		int markFinal = inputInt.nextInt();
		SS[i] = new StudentScore(lastName, name, ID, markProcess, markFinal);
	}
	
	/** add or update mark of student */
	public void addNewMark(){
		System.out.print("Enter StudentID: ");
		int ID = inputInt.nextInt();
		if(find(ID)==-1){
			System.out.print("Enter lastname of student: ");
			String lastName = inputString.nextLine();
			System.out.print("Enter fistname of student: ");
			String name = inputString.nextLine();
			System.out.print("Enter mark process: ");
			int markProcess = inputInt.nextInt();
			System.out.print("Enter mark final: ");
			int markFinal = inputInt.nextInt();
			SS[noStudent] = new StudentScore(lastName, name, ID, markProcess, markFinal);
			noStudent++;
			update();
		}
		else{
			System.out.print("This student has exist.Do you want update mark(yes:enter y, no: enter other key: ");
			String choose = inputString.nextLine();
			if(choose.compareTo("y")==0){
				System.out.print("Enter lastname of student: ");
				String lastName = inputString.nextLine();
				System.out.print("Enter fistname of student: ");
				String name = inputString.nextLine();
				System.out.print("Enter mark process: ");
				int markProcess = inputInt.nextInt();
				System.out.print("Enter mark final: ");
				int markFinal = inputInt.nextInt();
				SS[find(ID)] = new StudentScore(lastName, name, ID, markProcess, markFinal);
				update();
			}
		}
	}
	
	/**  remove a student*/
	public boolean removeMark(){
		System.out.print("Enter StudentID: ");
		int ID = inputInt.nextInt();
		if(find(ID)!=-1){
			if(find(ID)!=noStudent-1)
				for(int i=find(ID); i<noStudent-1; i++) SS[i] = SS[i+1];
			
			SS[noStudent-1] = null;
			noStudent -= noStudent;
			update();
			return true;
		}
		else {
			System.out.println("error");
			return false;
		}
	}
	
	/** update file score */
	public void update(){
		for(int i = 0; i< noStudent-1; i++){
			StudentScore s = new StudentScore();
			if(SS[i].getName().compareTo(SS[i+1].getName())>0){
				s = SS[i];
				SS[i] = SS[i+1];
				SS[i+1] = s;
			}
		}
		try(PrintWriter writer  = new PrintWriter(new FileWriter("D:"+Sbt.getID()+"_"+ semesterID+".txt",false))){
			 	writer.println("SubjectID|"+Sbt.getID());
			 	writer.println("Subject|"+Sbt.getName());
			 	writer.println("F|"+Sbt.getCoefficientProcess()+"|"+Sbt.getCoefficientFinal());
			 	writer.println("Semester|"+String.valueOf(semesterID));
			 	writer.println("StudentCount|"+String.valueOf(noStudent));
				for(int j = 0; j < noStudent; j++)
				writer.println(SS[j].getMarkLine(Sbt.getCoefficientProcess()));
				writer.close();
				}catch(FileNotFoundException e){
				System.out.println(e.getMessage());
				}catch(IOException e){
				System.out.println(e.getMessage());
			}
		
		
	}
	
	/** set score report */
	public void setReport(){
		StudentScore max = SS[0];
		StudentScore min = SS[0];
		float average = 0;
		int a=0,b=0, c= 0, d=0, f=0;
		for(int i = 0; i< noStudent-1; i++){
			
			if(SS[i].getTotalMark(Sbt.getCoefficientProcess()) < SS[i+1].getTotalMark(Sbt.getCoefficientProcess()))
				min = SS[i+1];
			else max = SS[i+1];
			}
		for(int i = 0; i< noStudent; i++){
			average += SS[i].getTotalMark(Sbt.getCoefficientProcess());
			switch (SS[i].getMark(Sbt.getCoefficientProcess())) {
			case 'A': a++; break;
			case 'B': b++; break;
			case 'C': c++; break;
			case 'D': d++; break;
			case 'F': f++; break;
			}
		}
		File fileReport = new File("D://ScoreBoard//"+Sbt.getID()+"_"+ semesterID+"_rp.txt");
		if(fileReport.exists()){
			try {
				fileReport.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try(PrintWriter writer  = new PrintWriter(new FileWriter("D:"+Sbt.getID()+"_"+ semesterID+"_rp.txt",false))){
				writer.println(Sbt.getID()+"_"+ semesterID+"_rp.txt");
				writer.println("The student with the highest mark is:"+ max.getLastName()+" "+ max.getName());
				writer.println("The student with the lowest mark is:"+ min.getLastName()+" "+ min.getName());
				writer.println("The average mark is:"+ String.valueOf(average));
				writer.println("A histogram of the subject IT3650 is:");
				writer.println("A:"+a);
				writer.println("B:"+b);
				writer.println("C:"+c);
				writer.println("D:"+d);
				writer.println("F:"+f);
				writer.close();
				}catch(FileNotFoundException e){
				System.out.println(e.getMessage());
				}catch(IOException e){
				System.out.println(e.getMessage());
		}
	}
	
	/** display score and report */
	public void display (){
		update();
		setReport();
			try(BufferedReader reader = new BufferedReader(new FileReader("D:"+Sbt.getID()+"_"+ semesterID+".txt"));
					BufferedReader reader2 = new BufferedReader(new FileReader("D:"+Sbt.getID()+"_"+ semesterID+"_rp.txt"))){
				String line;
				do {
					if((line = reader.readLine()) != null)
					System.out.println(line);
					}while(line != null);
				do {
					if((line = reader2.readLine()) != null)
					System.out.println(line);
					}while(line != null);
				}
					catch(FileNotFoundException e){
					System.out.println(e.getMessage());
					}
					catch(IOException e){
					System.out.println(e.getMessage());
					}
		}
	
	/**
	 * @return the iD
	 */
	public int getSemesterID() {
		return semesterID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setSemesterID(int iD) {
		semesterID = iD;
	}
	/**
	 * @return the noStudent
	 */
	public int getNoStudent() {
		return noStudent;
	}
	/**
	 * @param noStudent the noStudent to set
	 */
	public void setNoStudent(int noStudent) {
		this.noStudent = noStudent;
	}
	/**
	 * @return the sbt
	 */
	public Subject getSbt() {
		return Sbt;
	}
	/**
	 * @param sbt the sbt to set
	 */
	public void setSbt(Subject sbt) {
		Sbt = sbt;
	}
	
}
