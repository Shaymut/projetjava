package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Element;

public class Keyboard implements KeyListener{
	
	public Order order = Order.RIGHT;
	public boolean toucheUp = false;
    public boolean toucheLeft = false;
    public boolean toucheDown = false;
    public boolean toucheRight = false;
    private int nextY;
    private int nextX;

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)  { //Flèche droite
			System.out.println("Touche appyée : Droite");
			this.order = Order.RIGHT;
			}
	
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			System.out.println("Touche appyée : Left");
			this.order = Order.LEFT;
		
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("Touche appyée : Bas");
			this.order = Order.DOWN;
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("Touche appyée : Haut");
			this.order = Order.UP;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("Touche appyée : Espace");
			this.order = Order.SPACE;
			
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
	public void keyReleased(KeyEvent e) { //remise à 0 lors du relachement des touches
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)  { //Flèche droite
			 
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

