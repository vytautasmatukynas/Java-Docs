
public class App {

	public static void main(String[] args) {
		BankAccount current = new Current(0);
		BankAccount savings = new Savings(0);

		current.deposit(5000);
		current.withdraw(1500);
		System.out.println(current);

		savings.deposit(10000);
		savings.withdraw(1200);
		System.out.println(savings);

		checkPalukanos(current);
		checkPalukanos(savings);

	}

	private static void checkPalukanos(BankAccount account) {
		if (account instanceof Current)
			((Current) account).interest(account.getMoney());

		else if (account instanceof Savings)
			((Savings) account).interest(account.getMoney());
	}

}
