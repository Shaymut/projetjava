package model;

public class Ground extends MotionlessElement{
	
	/**
	 * 
	 * character used for BDD
	 * 
	 * @see Ground#Ground(Position) 
	 */
	
	static char sprite = 'X';
	
	/**
	 * 
	 * Permeability of the object
	 * 
	 * @see Ground#Ground(Position)
	 */
	
	static Permeability permeability = Permeability.PENETRABLE;
	
	/**
	 * 
	 * Constructor Ground
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	public Ground(Position position) {
		super(permeability, sprite, position);
	}
}