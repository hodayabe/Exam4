
public class Tent {

	private int numPeople;
	private double width;
	private double length;
	private double height;
	
	
	public Tent(int numPeople, double width, double length, double height) {
		this.numPeople = numPeople;
		this.width = width;
		this.length = length;
		this.height = height;
	}


	public int getNumPeople() {
		return numPeople;
	}


	public double getWidth() {
		return width;
	}


	public double getLength() {
		return length;
	}


	public double getHeight() {
		return height;
	}

	public double getArea() {
		return width*length;
	}


	@Override
	public String toString() {
		return "Tent [numPeople=" + numPeople + ", width=" + width + ", length=" + length + ", height=" + height + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
