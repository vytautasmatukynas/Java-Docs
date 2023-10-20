
public abstract class BankAccount {

	private double money;

	public BankAccount(double money) {
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	public void deposit(int value) {
		money += value;
	}
	
	public void withdraw(int value) {
		money -= value;
	}
	
	public abstract void interest(double money);

	@Override
	public String toString() {
		return "[money=" + money + "]";
	}
	
}
