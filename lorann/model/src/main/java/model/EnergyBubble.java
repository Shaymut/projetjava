package model;

public class EnergyBubble extends MotionlessElement{
	
	static char sprite = 'P';
	static String image = "/Pictures/cristal_ball.png";
	static Permeability permeability = Permeability.COLLECATBLE;
	
	EnergyBubble(Position position) {
		super(permeability, sprite, image, position);
	}
}