package samsung.java.week2.bank;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import samsung.java.week2.subject.Subject;

public class BankManagement {
	private SavingAccount account[] = new SavingAccount[50];
	private int i=0;			// i is number of subjiects
	Scanner inputString = new Scanner(System.in);
	Scanner inputDouble = new Scanner(System.in);
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
				case(1): appendAccount();
						enterKey();
						break;
				case(2): withdrawInterest();
						enterKey();
						break;
				case(3): partialyWithdraw();
						enterKey();
						break;
				case(4): totalWithdraw();
						enterKey();
						break;
				case(5): deposit();
						enterKey();
						break;
				case(6): displayAccountInfo();
						enterKey();
						break;
				default: break;
			}
		}while(menu>=1&&menu<=6);
	}
	/** Press Enter to continue */
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
	/** Find account and location of account
	 * 
	 * @param accountID account ID of find_account
	 * @return if don't exist account reurn -1 else return location of account
	 */
	public int find(String accountID){
		int n = -1;
		for(int j=0;j<i;j++)
			if(accountID.compareTo(account[j].getAccountID())==0){
				n = j;
				break;
			}
		return n;
	}
	/** Enter account ID end find account
	 * 
	 * @return if don't exist account reurn -1 else return location of account
	 */
	public int enterAndFind(){
		System.out.print("Enter account ID: ");
		String accountID = inputString.nextLine();
		int n = find(accountID);
		if(n==-1) System.out.println("Error! This account ID doesn't exist");
		return n;
	}
	/** show menu */
	public static void showMenu(){
		System.out.println("Bank Management System  ");
		System.out.println("-------------------------------------");
		System.out.println("1.  Append new account  ");
		System.out.println("2.  Withdraw interest  ");
		System.out.println("3.  Partialy withdraw");
		System.out.println("4.  Totally withdraw ");
		System.out.println("5.  Deposit");
		System.out.println("6.  Display information");
		System.out.println("Your choice (1-6, other to quit)");
	}
	/** Append a account */
	public void appendAccount(){
		System.out.print("Enter account ID: ");
		String accountID = inputString.nextLine();
		if(find(accountID)==-1){
			System.out.print("Enter account's name: ");
			String accountName = inputString.nextLine();
			System.out.print("Enter principal amount: ");
			double principalAmount = inputDouble.nextDouble();
			System.out.print("Enter interestRate(%): ");
			float interestRate = inputFloat.nextFloat();
			System.out.print("Enter account's Date (dd/MM/yyyy): ");
			Date accountDate = SavingAccount.getNewDate();
			account[i] =  new SavingAccount(accountID,accountName,principalAmount,interestRate,accountDate);
			i++;
		}
		else System.out.println("Error! This account ID has existed");
	}
	/** withdraw interest a account */
	public void withdrawInterest(){
		int j = enterAndFind();
		if(j!=-1){
				account[j].withdrawInterest();
				System.out.println("Succerful!");
			}
	}
	/** partialy withdraw a account */
	public void partialyWithdraw(){
		int j = enterAndFind();
		if(j!=-1){
				account[j].partialyWithdraw();
				System.out.println("Succerful!");
			}
	}
	/** total withdraw a account */
	public void totalWithdraw(){
		int j = enterAndFind();
		if(j!=-1){
				account[j].totallyWithdraw();
				System.out.println("Succerful!");
			}
	}
	/** deposit a account */
	public void deposit(){
		int j = enterAndFind();
		if(j!=-1){
				account[j].deposit();
				System.out.println("Succerful!");
			}
	}
	/** display information of a account */
	public void displayAccountInfo(){
		int j = enterAndFind();
		if(j!=-1){
				account[j].displayAccountInfo();
				System.out.println("Succerful!");
			}
	}
}
