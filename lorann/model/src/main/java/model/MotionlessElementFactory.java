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
			case 'V':
				createVerticalBone(position);
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
	
	public MotionlessElement createVerticalBone(Position position) {
		MotionlessElement VerticalBone = new VerticalBone(position);
		return VerticalBone;
	}
	
	public MotionlessElement createHorizontalBone(Position position) {
		MotionlessElement HorizontalBone = new HorizontalBone(position);
		return HorizontalBone;
	}
	
	public MotionlessElement createDoorOpened(Position position) {
		MotionlessElement DoorOpened = new DoorOpened(position);
		return DoorOpened;
	}
	
	public MotionlessElement createDoorClosed(Position position) {
		MotionlessElement DoorClosed = new DoorClosed(position);
		return DoorClosed;
	}
	
	
}
