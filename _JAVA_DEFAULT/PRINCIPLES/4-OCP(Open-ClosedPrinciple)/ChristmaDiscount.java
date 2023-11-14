
public class ChristmaDiscount implements Discount{

	@Override
	public long countDicount(Product product) {
		long discount = (long) (product.getPrice() * 0.8);
		return discount;
	}

}
