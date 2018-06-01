package model;


import java.awt.Image;

import javax.swing.ImageIcon;

public class Mobile extends Element implements IMobile{

    private boolean alive = true;

    private  Position position;
 
    private int nextY;
    private int nextX;

    // private IBoard board;

    public int getNextY() {
		return nextY;
	}

	public void setNextY(int nextY) {
		this.nextY = nextY;
	}

	public int getNextX() {
		return nextX;
	}

	public void setNextX(int nextX) {
		this.nextX = nextX;
	}

	Mobile(Permeability permeability, char sprite, Image image, Position position,ImageIcon icoImage) {
        super(permeability, sprite, image, position, icoImage);
        // TODO Auto-generated constructor stub
    }


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void moveUp() {
    	  setNextY(position.getY()-1); //On Sauvegarde l'ancienne position dans une variable temporaire afin de sauvegardé et ensuite 
          //Mettre les méthodes de collision
          position.setY(nextY);
    }

    public void moveDown() {
    	setNextY(position.getY()+1);
    	position.setY(nextY);
        }

    public void moveLeft() {
    	setNextX(position.getX()-1);
    	position.setX(nextX);
    }

    public void moveRight() {
    	setNextX(position.getX()+1);
    	position.setX(nextX);
    }

    public void moveUpLeft() {
    	setNextY(position.getY()-1);
    	setNextX(position.getX()-1);
    	position.setX(nextX);
        position.setY(nextY);
    }

    public void moveUpRight() {
    	 setNextY(position.getY()-1); 
         setNextX(position.getX()+1);
     	position.setX(nextX);
     	position.setY(nextY);
    }

    public void moveDownLeft() {
    	setNextY(position.getY()+1);
    	setNextX(position.getX()-1);
    	position.setX(nextX);
    	position.setY(nextY);
    }

    public void moveDownRight() {
    	setNextY(position.getY()+1);
    	setNextX(position.getX()+1);
    	position.setX(nextX);
    	position.setY(nextY);
    	
    }






}