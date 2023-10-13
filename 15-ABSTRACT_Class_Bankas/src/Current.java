
public class Current extends BankAccount{
	
	double proc = 0;
	
	public Current(double money) {
		super(money);
	}
	
	@Override
	public void interest(double money) {
		System.out.println("Metines palukanos \"Current\": " + (money * proc) + " | Po metu turesit: " + (money + (money * proc)));
		
	}
	
	@Override
	public String toString() {
		return "BankAccount Current: " + super.toString();
	}
}
