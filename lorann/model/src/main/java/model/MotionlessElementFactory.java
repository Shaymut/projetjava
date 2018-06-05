package model;

public class MotionlessElementFactory {
	
	/**
	 * 
	 * Creation of elements
	 * 
	 * @see MotionlessElementFactory#createMotionlessElement(char, Position)
	 * 
	 */
	
	Element element = null;
	
	/**
	 * 
	 * Factory creating elements for the map
	 * 
	 * @param sprite
	 * @param position
	 * @return elements
	 */
	
	public Element createMotionlessElement(char sprite, Position position) {
		switch(sprite) {
			case 'G':
				element = new Gold(position);
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
		}
		return element;
	}

}
