package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
    private static Dimension PANEL_SIZE;
    private static final int REFRESH_RATE = 250;
    private static final int CHARACTER_WIDTH = 32;
    
    Image Image;
    
    private Timer timer = new Timer(REFRESH_RATE, this);
    private int currentRow = 0;
    private int currentCol = 0;
    
    Element[][] mapNiveau;
    
    BufferedImage image = null;

    public Panel(int x, int y, Element[][] mapNiveau) {
    	Panel.PANEL_SIZE = new Dimension(x, y);
    	this.mapNiveau = mapNiveau;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer.start();
    }
    
    public Dimension getPreferredSize() {
        return PANEL_SIZE;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for (int i = 0; i<= 19; i++) {
        	for (int j = 0; j<= 11; j++) {
        		try {
        			image = ImageIO.read(new File(getClass().getResource("/picture2/bone.png").toURI()));
        			g.drawImage(image, i*32, j*32, this);
        		} catch (IOException | URISyntaxException e) {
        			e.printStackTrace();
        		}
        		
        		
        	}
        }
        
		try {
			image = ImageIO.read(new File(getClass().getResource("/picture2/lorann_l.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		g.drawImage(image, currentCol, currentRow, this);
		
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        int rowIncrement = 0;
        int colIncrement = 0;

        if(code == KeyEvent.VK_LEFT) {
        	colIncrement = colIncrement - 32;
        }
        else if(code == KeyEvent.VK_RIGHT) {
        	colIncrement = colIncrement + 32;
        }
        else if(code == KeyEvent.VK_UP) {
        	rowIncrement = rowIncrement - 32;
        }
        else {
            if(code == KeyEvent.VK_DOWN) {
            	rowIncrement = rowIncrement + 32;
            }
        }

        if(isInBounds(rowIncrement, colIncrement)) {
            currentRow += rowIncrement;
            currentCol += colIncrement;
            repaint();
        }
    }

    private boolean isInBounds(int rowIncrement, int colIncrement) {
        int top = currentRow + rowIncrement;
        int left = currentCol + colIncrement;
        int right = left + CHARACTER_WIDTH;
        int bottom = top + CHARACTER_WIDTH;

        return (top >= 0 && left >= 0 && right <= PANEL_SIZE.getWidth() && bottom <= PANEL_SIZE.getHeight());       
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {		
	}
}
