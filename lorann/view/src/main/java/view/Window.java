package view;

import model.*;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.IController;

public class Window extends JFrame implements KeyListener{
	
    private static final long serialVersionUID = 1L;
    
    Panel panel;
   
    IController controller;
    
    public String Touche;
    private Order order = Order.NONE;

    public Window(String name, int x, int y, Element[][] mapNiveau) {
        super(name);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(this.panel= new Panel(630, 374, mapNiveau), BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    void updateFrame() {
    	this.panel.updatePanel();
    }
    
    public Order getOrder() {
    	return this.order;
    }
    
    public void setController(IController controller) {
    	this.controller = controller;
    }
    
    public void setMap(Element[][] mapNiveau) {
    	this.panel.setMap(mapNiveau);
    }
    
    public void killFrame() {
    	this.setVisible(false);
    }
    
    
    //---------------------KEYBOARD---------------------
        
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_NUMPAD6)  { //Flèche droite
			this.order = Order.RIGHT;
			Touche = "Right";
			
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			this.order = Order.LEFT;
			Touche = "Left";
			
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			this.order = Order.DOWN;
			Touche = "Down";
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
			this.order = Order.UP;
			Touche = "UP";
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			this.order = Order.SPACE;
			
			System.out.println("FIRE!");
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
			this.order = Order.LEFT_UP;
			Touche = "Left-Up";
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
			this.order = Order.RIGHT_UP;
			Touche = "Right-Up";
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
			this.order = Order.LEFT_DOWN;
			Touche = "Left-Down";
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			this.order = Order.RIGHT_DOWN;
			Touche = "Right-Down";
		}else {
			this.order = Order.NONE;
		}
		controller.updatemoveLorann();
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_NUMPAD6 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD4 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD2 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD8 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD5 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD7 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD9 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD1 ||
		   e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			this.order = Order.NONE;
		}
	}	
}
    
