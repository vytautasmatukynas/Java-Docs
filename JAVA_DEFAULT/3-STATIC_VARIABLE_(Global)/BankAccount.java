
public class BankAccount {

	// static is like global variable inside class scope
	private static int numberOfAccounts = 0;
//	private int  numberOfAccounts = 0;
	private int balance;

	public BankAccount() {
		numberOfAccounts++;
		setBalance(numberOfAccounts);
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int numberOfAccountsPublic() {
		return numberOfAccounts;
	}

	public static int numberOfAccountsPublicStatic() {
		return numberOfAccounts;
	}

}
