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
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)  { //Flèche droite
			this.order = Order.RIGHT;
			}
	
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.order = Order.LEFT;
		
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			this.order = Order.DOWN;
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			this.order = Order.UP;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.order = Order.SPACE;
		}
		System.out.println(order);
		controller.updatemove();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
	}
	
	

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT ||
		   e.getKeyCode() == KeyEvent.VK_LEFT ||
		   e.getKeyCode() == KeyEvent.VK_DOWN ||
		   e.getKeyCode() == KeyEvent.VK_UP ||
		   e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.order = Order.NONE;
		}
	}	
}
    
