
public class Rectangle {

	protected int width;
	protected int height;
	
	public Rectangle setWidth(int width) {
		this.width = width;
		return this;
	}

	public Rectangle setHeight(int height) {
		this.height = height;
		return this;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + "]";
	}
	
	

}
