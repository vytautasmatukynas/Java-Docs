
public class Square extends Rectangle{

	public Square setWidth(int width) {
		this.width = width;
		return this;
	}

	@Override
	public String toString() {
		return "Square [width=" + width + "]";
	}

	
}
