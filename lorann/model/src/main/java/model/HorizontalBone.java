package model;

public class HorizontalBone extends MotionlessElement{
	/**
	 * 
	 * character used for BDD
	 * 
	 * @see HorizontalBone#HorizontalBone(Position) 
	 */

	static char sprite = 'H';
	
	/**
	 * 
	 * Permeability of the object
	 * 
	 * @see HorizontalBone#HorizontalBone(Position) 
	 *
	 */

	
	static Permeability permeability = Permeability.BLOCK;
	
	/**
	 * 
	 * Constructor HorizontalBone
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	HorizontalBone(Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet HorizontalBone");
	}
}