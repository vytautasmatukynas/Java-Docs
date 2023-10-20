
public class Savings extends BankAccount{

	double proc = 0.05;

	public Savings(double money) {
		super(money);
	}

	@Override
	public void interest(double money) {
		System.out.println("Metines palukanos \"Savings\": " + (money * proc) + " | Po metu turesit: " + (money + (money * proc)));
	}
	
	@Override
	public String toString() {
		return "BankAccount Savings: " + super.toString();
	}

}
