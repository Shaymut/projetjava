package model;

public class Evil extends Mobile implements Kill{

	static Permeability permeability = Permeability.BLOCK;
	
	Evil(char sprite, Position position) {
		super(permeability, sprite, position);
		System.out.println("Création d'un objet Evil");
	
	}
	
	

	public void kill() {
		
	
		
	}
	


}
