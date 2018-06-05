package model;

public class MobileElementFactory {

	Element element = null;	
	
	public Element createMobileElement(char sprite, Position position) {
		switch(sprite) {
			case 'P':
				element= new Spell(position);
				break;
			case 'F':
				element = new EvilHorizontal(position);
				break;
			case 'K':
				element = new EvilVertical(position);
				break;
			case 'J' :
				element = new EvilPingPong(position);
				break;
			default :
				System.out.println("Il y a un sprite dans la BDD qui n'existe pas dans le switch case : " + sprite);
		}
		return element;
	}
}
