package bankAccount;

public class BankTester {

	public static void main(String[] args) {
		BankAccount acct1 = new BankAccount();
		BankAccount acct2 = new BankAccount();
		BankAccount acct3 = new BankAccount();
		
		acct1.getCheckingAmt();
		acct1.getSavingAmt();
		acct1.deposit(234, "saving");
		acct1.deposit(4, "checking");
		acct1.withdraw(4, "saving");
		acct1.withdraw(5, "checking");
		acct1.acctBalance(acct1.getAccountNum());		

	}

}
