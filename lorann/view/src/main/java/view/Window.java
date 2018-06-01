package view;

import model.*;
import java.awt.BorderLayout;
import javax.swing.*;

public class Window extends JFrame {
	
    private static final long serialVersionUID = 1L;
    
    Panel panel;

    public Window(String name, int x, int y, Element[][] mapNiveau) {
        super(name);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(this.panel= new Panel(630, 374, mapNiveau), BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    void updateFrame() {
    	this.panel.updatePanel();
    }
}
    
