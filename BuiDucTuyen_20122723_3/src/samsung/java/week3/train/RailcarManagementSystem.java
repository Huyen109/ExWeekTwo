package samsung.java.week3.train;

import java.io.IOException;
import java.util.Scanner;

public class RailcarManagementSystem {
	private RailCar R[] = new RailCar[40];
	private PassengerCarriage P[] = new PassengerCarriage[40];
	private GoodsCar G[] = new GoodsCar[40];
	private int x,y,z;
	Scanner inputString = new Scanner(System.in);
	Scanner inputInt = new Scanner(System.in);
	Scanner inputFloat = new Scanner(System.in);
	Scanner pressKey = new Scanner(System.in);
	/** constructor method */
	public RailcarManagementSystem(){
		this.x = 0;
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
				case(1): appendRailCar();
						enterKey();
						break;
				case(2): displayInformations();
						enterKey();
						break;
				case(3): passengerGetOff();
						enterKey();
						break;
				case(4): passengerTake();
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
		System.out.println("Railcar Management System ");
		System.out.println("-------------------------------------");
		System.out.println("1.  Append new railcar ");
		System.out.println("2.  Display the information of train ");
		System.out.println("3.  Passenger gets off the train  ");
		System.out.println("4.  Passenger takes the train ");
		System.out.println("Your choice (1-4, other to quit)");
	}
	/** Find railcar and location of railcar
	 * 
	 * @param railcarID of find_subject
	 * @return if don't exist railcar reurn -1 else return location of railcar
	 */
	public int find(String railcarID){
		int n = -1;
		for(int j=0;j<x;j++)
			if(railcarID.compareTo(R[j].getID())==0){
				n = j;
				break;
			}
		return n;
	}
	/** Find PassengerCarriage and location of PassengerCarriage
	 * 
	 * @param ID of find_subject
	 * @return if don't exist PassengerCarriage reurn -1 else return location of PassengerCarriage
	 */
	public int findPassengerCarriage(String ID){
		int n = -1;
		for(int j=0;j<y;j++)
			if(ID.compareTo(P[j].getID())==0){
				n = j;
				break;
			}
		return n;
	}
	/** Find GoodsCar and location of GoodsCar
	 * 
	 * @param ID of find_subject
	 * @return if don't exist GoodsCar reurn -1 else return location of GoodsCar
	 */
	public int findGoodsCar(String ID){
		int n = -1;
		for(int j=0;j<z;j++)
			if(ID.compareTo(G[j].getID())==0){
				n = j;
				break;
			}
		return n;
	}
	/** append a railcar */
	public void appendRailCar(){
		System.out.print("Enter Railcar ID: ");
		String ID = inputString.nextLine();
		if(find(ID)==-1 && findPassengerCarriage(ID)==-1 && findGoodsCar(ID)==-1){
			System.out.print("Enter weight of railcar: ");
			float weight = inputFloat.nextFloat();
			int choose =0;
			while(choose!=1 &&choose!=2 && choose!=3){
				System.out.print("Enter type railcar(passengercarriage: enter 1, googscar: enter 2, other railcar:enter 3): ");
				choose = inputInt.nextInt();
				switch(choose){
				case 1:
					System.out.print("Enter nomber of passenger: ");
					int no = inputInt.nextInt();
					P[y] = new PassengerCarriage(no,weight,ID);
					y++;
					break;
				case 2:
					System.out.print("Enter weight of goods: ");
					float goodsWeight = inputFloat.nextFloat();
					G[z] = new GoodsCar(goodsWeight,weight,ID);
					z++;
					break;
				case 3:
					R[x] = new RailCar(weight,ID);
					x++;
					break;
				default: System.out.println("error! ");
				}
			}
		}
		else System.out.println("Error! This railcar ID has existed");
	}
	/** display informations */
	public void displayInformations(){
		System.out.println("Passengercarriage:");
		for (int i=0;i<y;i++) P[i].displayInformations();
		System.out.println("Goodscar:");
		for (int i=0;i<z;i++) G[i].displayInformations();
		System.out.println("Other railcar:");
		for (int i=0;i<z;i++) R[i].displayInformations();
	}
	/** passenger get off the train */
	public void passengerGetOff(){
		System.out.print("Enter railcar ID: ");
		String ID = inputString.nextLine();
		int i = findPassengerCarriage(ID);
		if(i != -1){
			System.out.print("Enter nomber of passenger gets off railcar: ");
			int no = inputInt.nextInt();
			P[i].passengerGetOff(no);
		}
		else System.out.println("error!");
	}
	/** passenger take the train */
	public void passengerTake(){
		System.out.print("Enter railcar ID: ");
		String ID = inputString.nextLine();
		int i = findPassengerCarriage(ID);
		if(i != -1){
			System.out.print("Enter nomber of passenger take the railcar: ");
			int no = inputInt.nextInt();
			P[i].passengerTake(no);
		}
		else System.out.println("error!");
	}
}
