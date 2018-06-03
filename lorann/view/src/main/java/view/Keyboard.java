package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Element;

public class Keyboard implements KeyListener{
	
	
	
	 public boolean toucheUp = false;
     public boolean toucheLeft = false;
     public boolean toucheDown = false;
     public boolean toucheRight = false;
     private int nextY;
     private int nextX;
     private Element lorann;

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)  { //Fl�che droite
			System.out.println("Touche appy�e : Droite");
			
			toucheRight = true;
			/*if(toucheRight == true) {
				//setNextX(Lorann.l);
		    //	position.setX(nextX);
				
			}*/
		
			}
	
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("Touche appy�e : Left");
			toucheLeft = true;
		
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("Touche appy�e : Bas");
		
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("Touche appy�e : Haut");
			toucheUp = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Touche appy�e : Espace");
			//Mettre ici la m�thode pour le lancer du pouvoir
			
		}
	}

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
	
	public Element getLorann() {
		return this.lorann;
	}
	
	public void setLorann(Element lorann) {
		this.lorann = lorann;
	}
	
	    
	@Override
	public void keyReleased(KeyEvent e) { //remise � 0 lors du relachement des touches
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)  { //Fl�che droite
			 
			toucheRight = false;
			}
	
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			toucheLeft = false;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			toucheDown = false;
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			toucheUp = false;
			
		}
	}
		
	

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	}
