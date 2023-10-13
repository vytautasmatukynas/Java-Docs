
public class DefaultClass {
	
	private int a = 5;

	public DefaultClass add(int b) {
		a += b;
		return this;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "DefaultClass [a=" + a + "]";
	}
	
	

}
