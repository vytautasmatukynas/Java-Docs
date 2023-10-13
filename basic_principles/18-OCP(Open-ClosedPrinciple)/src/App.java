
public class App {

	public static void main(String[] args) {
		Product product = new Product(50);
		
		long chrDisc = new ChristmaDiscount().countDicount(product);
		long sumDisc = new SummerDiscount().countDicount(product);
		
		System.out.println(chrDisc);
		System.out.println(sumDisc);

	}

}
