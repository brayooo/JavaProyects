package co.edu.uptc.models;

public enum Limits {
	
	TOP(1), RIGHT(2), BOTTOM(3), LEFT(4);
	
	private int side;
	
	Limits(int side) {
		this.side = side;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
}
