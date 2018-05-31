package model;

public class MotionlessElementFactory {
	
	public void createMotionlessElement(char sprite, Position position) {
		switch(sprite) {
			case 'G':
				createGold(position);
				break;
			case 'E':
				createEnergy(position);
				break;
			case 'X':
				createGround(position);
				break;
			case 'S':
				createStone(position);
				break;
			
		}
	}
	
	public MotionlessElement createGold(Position position) {
		MotionlessElement Gold = new Gold(position);
		return Gold;
	}
	
	public MotionlessElement createEnergy(Position position) {
		MotionlessElement Energy = new EnergyBubble(position);
		return Energy;
	}
	
	public MotionlessElement createGround(Position position) {
		MotionlessElement Ground = new Ground(position);
		return Ground;
	}
	
	public MotionlessElement createStone(Position position) {
		MotionlessElement Stone = new Stone(position);
		return Stone;
	}
	
}
