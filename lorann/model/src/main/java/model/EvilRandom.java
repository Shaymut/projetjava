package model;

import java.util.Random;

public class EvilRandom extends Evil implements EvilMove{
	
	static char sprite = 'B';
	Random random = new Random();
	
	EvilRandom(Position position) {
		super(sprite, position);
		System.out.println("Création d'un objet EvilRandom");
	}
	
	   public void move() {

	         int ChoixMove = random.nextInt(8);
	         

	         switch(ChoixMove) {
	          case 0:
	          {
	              this.moveLeft(position);
	          }
	          break;
	          case 1: this.moveRight(position);
	          break;
	          case 2: this.moveDown(position);
	          break;
	          case 3: this.moveUp(position);
	          break;
	          case 4: this.moveUpRight(position);
	          break;
	          case 5: this.moveUpLeft(position);
	          break;
	          case 6: this.moveDownRight(position);
	          break;
	          case 7: this.moveDownLeft(position);
	          break;
	          default: 
	         }


	    }

	}

