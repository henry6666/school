package geometri;

import java.awt.Color;
import java.awt.Graphics;

/**
 * A class describing a square.
 * 
 * @author Johan Brook and Robin Andersson
 */
public class Square extends Rectangle {
	
	/** The side of the square */
	private int side;
	
	// Constructors
	
	/**
	 * Create a new <code>Square</code> with a side length. 
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 * @param side The side length
	 * @param color The color
	 * @throws IllegalPositionException If the coordinates are negative
	 */
	public Square(int x, int y, int side, Color color) 
			throws IllegalPositionException {}

	/**
	 * Create a new <code>Square</code> based on an existing
	 * <code>GeometricalForm</code>.
	 * 
	 * @param f The given form
	 * @param side The side length
	 * @param c The color
	 */
	public Square(GeometricalForm f, int side, Color c) {}
	
	
	/**
	 * Indicates if this square is equal to another square.
	 * 
	 * @return True if the squares are equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj){}
	
	
}