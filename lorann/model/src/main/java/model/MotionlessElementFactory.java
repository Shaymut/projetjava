package model;

public class MotionlessElementFactory {
	
	Element element = null;
	
	public Element createMotionlessElement(char sprite, Position position) {
		switch(sprite) {
			case 'G':
				//element = new Gold(position);
				element = new Ground(position);
				break;
			case 'E':
				element= new EnergyBubble(position);
				break;
			case 'X':
				element = new Ground(position);
				break;
			case 'S':
				element = new Stone(position);
				break;
			case 'V':
				element = new VerticalBone(position);
				break;
			case 'H' :
				element = new HorizontalBone(position);
				break;
			case 'O' :
				element = new DoorOpened(position);
				break;
			case 'C' :
				 element = new DoorClosed(position);
				 break;
			default :
				System.out.println("Il y a un sprite dans la BDD qui n'existe pas dans le switch case : " + sprite);
				//element = new Ground(position);
		}
		return element;
	}

	
	
	
	
	/*
	
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
	
	*/
}
