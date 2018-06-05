package model;

public class Lorann extends MobileElement{
	
	/**
	 * 
	 * character used for BDD
	 * 
	 * @see Lorann#Lorann(Position) 
	 */

	static char sprite = 'L';
	
	/**
	 * 
	 * Permeability of the object 
	 * 
	 * @see Lorann#Lorann(Position) 
	 */
	static Permeability permeability = Permeability.PENETRABLE;

	/**
	 * 
	 * Constructor HorizontalBone
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	Lorann(Position position) {
		super(permeability, sprite, position);
	}
	

	
}
	