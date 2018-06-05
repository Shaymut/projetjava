package view;

import model.*;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import controller.IController;

public class Window extends JFrame implements KeyListener{
	
    private static final long serialVersionUID = 1L;
    
    /**
     * 
     * Object panel
     * 
     * @see Window#Window(String, int, int, Element[][])
     * @see Window#updateFrame()
     * @see Window#setMap(Element[][])
     * 
     */
    
    Panel panel;
   
    IController controller;
    
    private Order order = Order.NONE;

    
    /**
     * 
     * @param name
     * @param x
     * @param y
     * @param mapNiveau
     */
   
    
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
    
    /**
     * 
     * Update the frames
     * 
     */
    
    void updateFrame() {
    	this.panel.updatePanel();
    }
    
    /**
     * 
     * Get the order
     * 
     * @see Window#order
     * 
     * @return the order
     */
    
    public Order getOrder() {
    	return this.order;
    }
    
    /**
     * 
     * Set the controller
     * 
     * @param controller
     */
    
    public void setController(IController controller) {
    	this.controller = controller;
    }
    
    /**
     * 
     * Set the map
     * 
     * @param mapNiveau
     * 
     */
    
    public void setMap(Element[][] mapNiveau) {
    	this.panel.setMap(mapNiveau);
    }
    
    /**
     * 
     * Set invisible a frame
     * 
     */
    
    public void killFrame() {
    	this.setVisible(false);
    }
    
    
    //---------------------KEYBOARD---------------------
        
    /**
     * 
     * Take the keyPressed and execute an order
     * 
     * @param e
     * 
     */
    
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_NUMPAD6)  { //Flèche droite
			this.order = Order.RIGHT;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			this.order = Order.LEFT;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			this.order = Order.DOWN;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
			this.order = Order.UP;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
			this.order = Order.SPACE;
			System.out.println("FIRE !");
			/*if (controller.getHaveSpell()){
				controller.fire();
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
			this.order = Order.LEFT_UP;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
			this.order = Order.RIGHT_UP;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
			this.order = Order.LEFT_DOWN;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else if(e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			this.order = Order.RIGHT_DOWN;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}else {
			this.order = Order.NONE;
			/*if (controller.getHaveSpell()){
				controller.setLastOrder(order);
			}*/
		}
		controller.updatemoveLorann();
	
	}
	
	@Override
	public void keyTyped(KeyEvent e) {		
	}

	/**
	 * 
	 * Take the key released and set the order at "NONE"
	 * 
	 * @param e
	 * 
	 */
	
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
    
