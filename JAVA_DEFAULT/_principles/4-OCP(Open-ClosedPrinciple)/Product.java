
public class Product{

	long price;

	public Product(long price) {
		this.price = price;
	}

	public long getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + "]";
	}
	
	

}
