package unl.soc.rectangle;

public class Rectangle {
	
	private final double xLeft;
	private final double xRight;
	
	private final double yBottom;
	private final double yTop;

	public Rectangle(double xLeft, double yBottom, double xRight, double yTop) {
		if(xLeft >= xRight) {
			throw new IllegalArgumentException(String.format("Invalid x-coordinates: (%f,%f)", xLeft, xRight));
		} else if(yBottom >= yTop) {
			throw new IllegalArgumentException(String.format("Invalid y-coordinates: (%f,%f)", yBottom, yTop));
		}
		this.xLeft = xLeft;
		this.yBottom = yBottom;
		this.xRight = xRight;
		this.yTop = yTop;
	}

	public double getxLeft() {
		return xLeft;
	}

	public double getxRight() {
		return xRight;
	}

	public double getyBottom() {
		return yBottom;
	}

	public double getyTop() {
		return yTop;
	}
	
	public double getArea() {
		return (this.xRight - this.xLeft) * (this.yTop - this.yBottom);
	}
	
	public Rectangle getIntersection(Rectangle r) {
		
		double xLeft  = Math.max(this.xLeft, r.xLeft);
		double xRight = Math.min(this.xRight, r.xRight);
		
		double yBottom = Math.max(this.yBottom, r.yBottom);
		double yTop    = Math.min(this.yTop, r.yTop);
		
		Rectangle intersection;
		try {
			intersection = new Rectangle(xLeft, yBottom, xRight, yTop);
		} catch(IllegalArgumentException e) {
			intersection = null;
		}
		return intersection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(xLeft);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(xRight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yBottom);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(yTop);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(xLeft) != Double.doubleToLongBits(other.xLeft))
			return false;
		if (Double.doubleToLongBits(xRight) != Double.doubleToLongBits(other.xRight))
			return false;
		if (Double.doubleToLongBits(yBottom) != Double.doubleToLongBits(other.yBottom))
			return false;
		if (Double.doubleToLongBits(yTop) != Double.doubleToLongBits(other.yTop))
			return false;
		return true;
	}
	
	
}
