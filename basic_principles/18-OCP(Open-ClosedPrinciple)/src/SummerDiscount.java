
public class SummerDiscount implements Discount{

	@Override
	public long countDicount(Product product) {
		long discount = (long) (product.getPrice() * 0.5);
		return discount;
	}
	
}
