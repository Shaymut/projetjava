package model;

import java.util.Random;

public class Element {
	/** The permeability. */
	Permeability permeability;
	/** The sprite. */
	char sprite;
	/** The position. */
	Position position;
	/** The random. */
	Random random = new Random();
	/**
     * Instantiates a new Element.
     *
     * @param permeability
     *            the permeability
     * @param sprite
     *            the sprite
     * @param position
     *            the position
     */
	public Element(Permeability permeability, char sprite, Position position){
		this.permeability = permeability;
		this.sprite = sprite;
		this.position = position;
	}
	
	/**
     * Gets the id.
     *
     * @return the sprite
     */
	public char getSprite() {
		return this.sprite;
	}
	
	/**
     * Gets the position.x.
     *
     * @return the position.x
     */
	public  int getX() {
		return this.position.getX();
	}
	
	/**
     * Gets the position.y.
     *
     * @return the position.y
     */
	public int getY() {
		return this.position.getY();
	}
	
	/**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
	public  void setX(int x) {
		this.position.x = x;
	}
	
	/**
     * Gets the position.
     *
     * @return the position
     */
	public Position getPosition() {
		return position;
	}
	
	/**
     * Sets the y.
     *
     * @param y
     *            the new y
     */
	public void setY(int y) {
		this.position.y = y;
	}
	
	/**
     * Sets the position.
     *
     * @param position
     *            the new position
     */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
     * Gets the permeability.
     *
     * @return the permeability
     */
	public Permeability getPermeability() {
		return this.permeability;
	}	
}
