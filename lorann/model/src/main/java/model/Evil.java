package model;

public class Evil extends MobileElement implements Kill{

	static Permeability permeability = Permeability.BLOCK;
	public Position position ; 
	int nextX;
	int nextY;
	
	Evil(char sprite, Position position) {
		super(permeability, sprite, position);
		System.out.println("Cr�ation d'un objet Evil");
	
	}
	
	

	public void kill() {
	//if(nextX == ) {
		
	//}
		 
	
		
	}
	


}
