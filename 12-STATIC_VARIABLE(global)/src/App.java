
public class App {

	public static void main(String[] args) {

		// 'numberOfAccounts' is global (static) inside BankAccount class and
		// when you create 'n' numbers of references it will go 'n'
		// times till last reference and you will get last value of it.
		// It saves previous returned value and counts forward with it, because it's
		// global (static) class variable.
		// Returns last result for each references. If there are +1, then every
		// reference result will be n+1 (1+1, 2+1, 3+1...).

		// If 'numberOfAccounts' isn't global (static) so it will go one time for each
		// reference.
		// Returns result of each reference.

		// 'balance' isn't global (static) so it will go one time for each reference.
		// Returns result of each reference.

		// if method is 'public' you have to create new reference (object).
		// if method is 'public static' you can call that method directly from class.
		System.out.println(
				"----- Print numberOfAccounts/balance by creating reference (object) " + "to class, method 'public'.");
		BankAccount acc1 = new BankAccount();
		System.out.println(acc1.numberOfAccountsPublic());
		System.out.println("-");
		BankAccount acc2 = new BankAccount();
		System.out.println(acc1.numberOfAccountsPublic());
		System.out.println("-");
		BankAccount acc3 = new BankAccount();
		System.out.println(acc1.numberOfAccountsPublic());

		System.out.println("----- Print object memmory address.");
		System.out.println(acc1);
		System.out.println("-");
		System.out.println(acc2);
		System.out.println("-");
		System.out.println(acc3);
		System.out.println("-");

		System.out.println("----- Print object values.");
		System.out.println(acc1.getBalance());
		System.out.println(acc1.numberOfAccountsPublic());
		System.out.println("-");
		System.out.println(acc2.getBalance());
		System.out.println(acc2.numberOfAccountsPublic());
		System.out.println("-");
		System.out.println(acc3.getBalance());
		System.out.println(acc3.numberOfAccountsPublic());

		System.out.println("----- Change acc1 to.");
		acc2.setBalance(5);

		System.out.println(acc1.getBalance());
		System.out.println(acc1.numberOfAccountsPublic());
		System.out.println("-");
		System.out.println(acc2.getBalance());
		System.out.println(acc2.numberOfAccountsPublic());
		System.out.println("-");
		System.out.println(acc3.getBalance());
		System.out.println(acc3.numberOfAccountsPublic());

		System.out.println("----- Print numberOfAccounts by calling directly to class, method 'public static'.");
		System.out.println(BankAccount.numberOfAccountsPublicStatic());

	}

}
