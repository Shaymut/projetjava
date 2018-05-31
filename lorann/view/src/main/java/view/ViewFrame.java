package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

import model.IModel;

public class ViewFrame extends JFrame implements KeyListener {

	/** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6563585351564617603L;
    private IModel model;
    
	void createViewFrame(String name) {
		this.setTitle(name);
		this.setModel(model);
		this.setVisible(true);
		
	}
    
	private void setModel(final IModel model) {
		this.model = model;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
