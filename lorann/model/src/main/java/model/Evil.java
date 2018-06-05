package model;

public class Evil extends MobileElement{

	
	/**
	 * 
	 * Permeability of the object
	 * 
	 * @see Evil#Evil(Position)
	 * 
	 */
	
	static Permeability permeability = Permeability.HURT;
	 
	/**
	 * 
	 * Constructeur Evil
	 * 
	 * @param {@link Position#Position(Position)}
	 * We get the position of this object
	 * @see {@link Position#Position(Position)}
	 */
	
	Evil(char sprite, Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet Evil");
	
	}
	


}
