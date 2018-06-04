package model;

import java.util.Random;

public class EvilRandom extends Evil implements EvilMove{
	
	static char sprite = 'B';
	Random random = new Random();
	
	EvilRandom(Position position, Map map) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilRandom");
	}
	
	   public void move() {

	         int ChoixMove = random.nextInt(8);
	         

	         switch(ChoixMove) {
	          case 0:
	          {
	              this.moveLeft();
	          }
	          break;
	          case 1: this.moveRight();
	          break;
	          case 2: this.moveDown();
	          break;
	          case 3: this.moveUp();
	          break;
	          case 4: this.moveUpRight();
	          break;
	          case 5: this.moveUpLeft();
	          break;
	          case 6: this.moveDownRight();
	          break;
	          case 7: this.moveDownLeft();
	          break;
	          default: 
	         }


	    }

	}

