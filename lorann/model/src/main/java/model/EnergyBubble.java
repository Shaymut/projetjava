package model;

public class EnergyBubble extends MotionlessElement{
	
	static char sprite = 'E';
	static String image = "cristal_ball.png";
	static Permeability permeability = Permeability.COLLECATBLE;
	
	EnergyBubble(Position position) {
		super(permeability, sprite, image, position);
	}
}