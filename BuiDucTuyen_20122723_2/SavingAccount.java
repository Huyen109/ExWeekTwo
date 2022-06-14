package samsung.java.week2.bank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SavingAccount {
	private String accountID;
	private String accountName;
	private double principalAmount;
	private Date accountDate;
	private float interestRate;
	private  Date today = new Date();
    Scanner inputDouble = new Scanner(System.in);

    /** Constructs a newly created Account object by    
	assigning initial values for attributes
	*@param initID : the ID of account
	*@param initName : the name of account
	*@param initprincipalAmount : the principal amount of account
	*@param initInterestRate :  the interest rate of account
	*/
	public SavingAccount(String initID, String initName, double 
			initPrincipalAmount, float initInterestRate,Date initDate){
		this.accountID = new String(initID);
		this.accountName = new String (initName);
		this.principalAmount = initPrincipalAmount;
		this.interestRate = initInterestRate;
		this.accountDate = initDate;
	}
	/** Get a new date
	 * 
	 * @return Date entered
	 */
	public static Date getNewDate(){
		String expectedPattern = "dd/MM/yyyy"; 
	    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern); 
	    Date date = null;
	    Scanner inputData3 = new Scanner(System.in);
	    String initString = inputData3.nextLine();
	    try 
	    { 
	        // (2) give the formatter a String that matches the 
	    	//SimpleDateFormat pattern 
	     date = formatter.parse(initString);      
	    }catch (ParseException e){ 
	      // execution will come here if the String that is given 
	      // does not match the expected format. 
	      e.printStackTrace(); 
	    }
	    return date;
	}
	/** Calculate interest 
	 * 
	 * @return interest value
	 */
	public double calculateInterest(){
		int noDay = (int)((today.getTime() - accountDate.getTime())/ (24 * 3600 * 1000)); // calculate number of day
		double interest = (principalAmount * interestRate * noDay/100); // calculate interest
		return interest;
	}
	/** withdraw interest and reset date's account */
	public void withdrawInterest(){
		System.out.println("Interest: "+calculateInterest());
		accountDate = today;
	}
	/** partialy withdraw and interest, reset date's account */
	public void partialyWithdraw(){
		System.out.print("Enter the amount: ");
		double amount = inputDouble.nextDouble();
		if(amount<0) System.out.println("Error!Negative amount!");
			else if(amount>principalAmount) System.out.println("Error!Exceed the principal amount!");
				else{
					double amount2 = amount + calculateInterest();
					System.out.println("The amount and interest: "+amount2);
					principalAmount -= amount;
					accountDate = today;
				}
	}
	/** Show interest and deposit */
	public void deposit(){
		System.out.println("Interest: "+calculateInterest());
		System.out.print("Enter the amount: ");
		double amount = inputDouble.nextDouble();
		if(amount<0) System.out.println("Error!Negative amount!");
			else {
				principalAmount += amount;
				accountDate = today;
			}
	}
	/** tolally withdraw */
	public void totallyWithdraw(){
		System.out.println("Principal amount and interest: "+(principalAmount + calculateInterest()));
		principalAmount = 0;
		accountDate = today;
	}
	/** display information of a account */
	public void displayAccountInfo(){
		System.out.println("Account ID: " + accountID);
		System.out.println("Account name: " + accountName);
		System.out.println("PrincipalAmount: " + principalAmount);
		System.out.println("InterestRate: " + interestRate);
		System.out.println("Interest: "+calculateInterest());
	}
	/** get AccountID */
	public String getAccountID() {
		return accountID;
	}
	/** set AccountID */
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	/** get Account name */
	public String getAccountName() {
		return accountName;
	}
	/** set Account name */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	/** get Principal Amount */
	public double getPrincipalAmount() {
		return principalAmount;
	}
	/** set Principal Amount */
	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}
	/** get Interest Rate */
	public float getInterestRate() {
		return interestRate;
	}
	/** set Interest Rate */
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	/** get Account Date */
	public Date getAccountDate() {
		return accountDate;
	}
	/** set Account Date */
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	
}
