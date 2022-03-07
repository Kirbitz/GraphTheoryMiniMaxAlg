/**
 * 
 */
package application;

/**
 * Holds X and Y coordinates for placing in a game board
 * @author Tyler Marefke, Tiernan Meyer
 * @date 11/17/2021
 */
public class Coordinate {
	private int xLocation;
	private int yLocation;
	
	
	/**
	 * Default Constructor for the coordinate class
	 */
	public Coordinate() {
		this.xLocation = -1;
		this.yLocation = -1;
	}
	
	/**
	 * Constructor for the coordinate class that takes in two int values to set for x and y locations
	 * @param xLocation
	 * @param yLocation
	 */
	public Coordinate(int xLocation, int yLocation) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
	}
	
	/**
	 * Returns the x location of the coordinate class
	 * @return xLocation - the x location
	 */
	public int getxLocation() {
		return xLocation;
	}
	
	/**
	 * Returns the y location of the coordinate class
	 * @return yLocation - the y location
	 */
	public int getyLocation() {
		return yLocation;
	}
	
	/**
	 * Command line form of the Coordinate
	 */
	public String toString() {
		return "(" + xLocation + ", " + yLocation + ")";
	}
}
