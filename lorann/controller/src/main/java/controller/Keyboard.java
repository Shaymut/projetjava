package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keyboard implements KeyListener{
	
	
	
	 public boolean toucheUp = false;
     public boolean toucheLeft = false;
     public boolean toucheDown = false;
     public boolean toucheRight = false;
     private int nextY;
     private int nextX;
     

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)  { //Fl�che droite
		 
			toucheRight = true;
		
			}
	
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			toucheLeft = true;
		
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
		
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			toucheUp = true;
			
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

