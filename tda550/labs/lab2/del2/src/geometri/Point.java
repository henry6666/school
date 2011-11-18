package geometri;

import java.awt.*;

/**
 * A class describing a point.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Point extends Shape {
	
	private final int POINT_SIZE = 1;
	
	/**
	 * Create a new <code>Point</code> on a position.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param c The color
	 * @throws IllegalPositionException If the coordinates are negative
	 */
	public Point(int x, int y, Color c) throws IllegalPositionException {
		super(x, y, c);
	}
	
	/**
	 * Create a new <code>Point</code> based on an existing
	 * <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param c The color
	 */
	public Point(GeometricalForm f, Color c) {
		super(f, c);
	}
	
	
	/**
	 * {@inheritDoc}
	 * @return The area for a <code>Point</code> is 0 (zero).
	 */
	@Override
	public int area() {
		return 0;
	}


	/**
	 * <p>Draw a point.</p>
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void fill(Graphics g) {
		g.setColor(getColor());
		g.fillOval(getX(), getY(), POINT_SIZE, POINT_SIZE);
	}

	/**
	 * {@inheritDoc}
	 * @return The perimeter of a <code>Point</code> is 0 (zero).
	 */
	@Override
	public int perimeter() {
		return 0;
	}

	@Override
	public String toString() {
		return super.toString() + " [POINT_SIZE=" + POINT_SIZE + "]";
	}
	
	
	/**
	 * Indicates if this rectangle is equal to another rectangle.
	 * 
	 * @return True if the rectangles are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj){
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		return super.equals(obj);
	
		
	}
	

}
