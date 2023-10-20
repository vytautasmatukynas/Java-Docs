
public class MultiPrinter implements PrintFunction, ScanFunction{

	@Override
	public void scan() {
		System.out.println("Can scan");
	}

	@Override
	public void print() {
		System.out.println("Can print");
	}

}
