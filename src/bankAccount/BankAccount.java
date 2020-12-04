package bankAccount;

public class BankAccount {
	//instance members
	//Users should not be able to set any of the attributes from the class.
	private String accountNum;
	private double checkingAmt;
	private double savingAmt;
	
	//static members
	//Create a class member (static) that has the number of accounts created thus far.
	private static int totalAccounts = 0;
	//Create a class member (static) that tracks the total amount of money stored in every account created.
	private static double grandBankTotal = 0;
	
	//constructor
	public BankAccount() {
		this.accountNum = generateAcctNum();//In the constructor, call the private method from above so that each user has a random ten digit account.
		this.checkingAmt = 0;
		this.savingAmt = 0;
		totalAccounts++;//In the constructor, be sure to increment the account count.

		System.out.printf("New account created: %s. Total number of Bank accounts: %d\n", this.accountNum, totalAccounts);
	}
	public BankAccount(String accountNum, double checkingAmt, double savingAmt) {
		this.accountNum = accountNum;
		this.checkingAmt = checkingAmt;
		this.savingAmt = savingAmt;
	}
	
	
	//getters and setters
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public double getCheckingAmt() {//Create a getter method for the user's checking account balance.
		return checkingAmt;
	}
	public void setCheckingAmt(double checkingAmt) {
		this.checkingAmt = checkingAmt;
	}
	public double getSavingAmt() {//Create a getter method for the user's saving account balance.
		return savingAmt;
	}
	public void setSavingAmt(double savingAmt) {
		this.savingAmt = savingAmt;
	}
	
	//methods
	//Create a private method that returns a random ten digit account number.
	private String generateAcctNum() {
		double random = Math.random();
		random *= 10E9;//make 10-digit
		long num = (long) random;//truncate decimal by turning into an int
		
		//convert to string
		String str = Long.toString(num);
		
		return str;
	}
	
	//deposit check
	//Create a method that will allow a user to deposit money into either the checking or saving, be sure to add to total amount stored.
	public void deposit(double amount, String acct) {
		//first check whether depositing in the checking or savings account
		if (acct.equals("saving")) {
			this.savingAmt += amount;
			System.out.printf("Depositing %.2f into savings account %s. New total is: $%.2f\n", amount, this.accountNum, getSavingAmt());
		}
		else if (acct.equals("checking")) {
			this.checkingAmt += amount;
			System.out.printf("Depositing %.2f into checkings account %s. New total is: $%.2f\n", amount, this.accountNum, getCheckingAmt());
		}
		else {
			System.out.println("Invalid account type. Please enter either saving or checking.");
		}
		
		grandBankTotal += amount;
		System.out.printf("The grand bank total is now $%.2f\n", grandBankTotal);
	}
	//withdraw money
	//Create a method to withdraw money from one balance. Do not allow them to withdraw money if there are insufficient funds.
	public void withdraw(double amount, String acct) {
		//first check whether depositing in the checking or savings account, then check for sufficient funds to withdraw
		if (acct.equals("saving")) {
			if(this.savingAmt - amount >= 0) {
				this.savingAmt -= amount;
				System.out.printf("Withdrawing %.2f from savings account %s. New total is: $%.2f\n", amount, this.accountNum, getSavingAmt());
			}
			else {
				System.out.println("Insufficient funds.");
				return;
			}
		}
		else if (acct.equals("checking")) {
			if(this.checkingAmt - amount >= 0) {
				this.checkingAmt -= amount;
				System.out.printf("Withdrawing %.2f from checkings account %s. New total is: $%.2f\n", amount, this.accountNum, getCheckingAmt());
			}
			else {
				System.out.println("Insufficient funds.");
				return;
			}
		}
		else {
			System.out.println("Invalid account type. Please enter either saving or checking.");
		}
		
		grandBankTotal -= amount;
		System.out.printf("The grand bank total is now $%.2f\n", grandBankTotal);
	}
	
	//Create a method to see the total money from the checking and saving.
	public void acctBalance(String account) {
		System.out.printf("Total balance of account# %s is $%.2f\n", this.accountNum, this.savingAmt+this.checkingAmt);
	}
	

}
