package model;

public class Position {
	
	/** The x. */
	int x;
	/** The y. */
	int y;
	
	/**
     * Instantiates a new Position.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     */
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
     * Instantiates a new Position.
     *
     * @param position
     *            the position
     */
	public Position(Position position){
		this.x = position.x;
		this.y = position.y;
	}
	
	/**
     * Gets the x.
     *
     * @return the x
     */
	public int getX() {
		return this.x;
	}
	
	/**
     * Gets the y.
     *
     * @return the y
     */
	public int getY() {
		return this.y;
	}
	
	/**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
     * Sets the y.
     *
     * @param y
     *            the new y
     */
	public void setY(int y) {
		this.y = y;
	}
	
}
