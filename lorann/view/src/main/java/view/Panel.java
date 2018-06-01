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
    //private static final int CHARACTER_WIDTH = 32;
    
    Image Image;
    
    //private int currentRow = 0;
    //private int currentCol = 0;
    
    Element[][] mapNiveau;
    
    BufferedImage image = null;

    public Panel(int x, int y, Element[][] mapNiveau) {
    	Panel.PANEL_SIZE = new Dimension(x, y);
    	this.mapNiveau = mapNiveau;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public Dimension getPreferredSize() {
        return PANEL_SIZE;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i = 0; i<= 19; i++) {
        	for (int j = 0; j<= 11; j++) {
        		try {
        			switch(this.mapNiveau[i][j].getSprite()) {
        			case 'S':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/bone.png").toURI()));
        				break;
        			case 'H':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/horizontal_bone.png").toURI()));
        				break;
        			case 'V':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/vertical_bone.png").toURI()));
        				break;
        			case 'X':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/ground.png").toURI()));
        				break;
        			case 'L':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/lorann_u.png").toURI()));
        				break;
        			case 'G':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/purse.png").toURI()));
        				break;
        			case 'E':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/crystal_ball.png").toURI()));
        				break;
        			case 'P':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/fireball_1.png").toURI()));
        				break;
        			case 'F':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/monster_1.png").toURI()));
        				break;
        			case 'K':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/monster_2.png").toURI()));
        				break;
        			case 'B':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/monster_3.png").toURI()));
        				break;
        			case 'J':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/monster_4.png").toURI()));
        				break;
        			case 'C':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/gate_closed.png").toURI()));
        				break;
        			case 'O':
        				image = ImageIO.read(new File(getClass().getResource("/picture2/gate_open.png").toURI()));
        				break;
        			}
        			
        			g.drawImage(image, i*32, j*32, this);
        		} catch (IOException | URISyntaxException e) {
        			e.printStackTrace();
        		}
        	}
        }
        
		/*try {
			image = ImageIO.read(new File(getClass().getResource("/picture2/lorann_u.png").toURI()));
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		g.drawImage(image, currentCol, currentRow, this);*/
		
    }

    public void keyPressed(KeyEvent touche) {
        int Button = touche.getKeyCode();
        int rowIncrement = 0;
        int colIncrement = 0;
        if(Button == KeyEvent.VK_LEFT) {
        	System.out.println("keyPressed : gauche");
        	//colIncrement = colIncrement - 32;
        }
        else if(Button == KeyEvent.VK_RIGHT) {
        	System.out.println("keyPressed : droite");
        	//colIncrement = colIncrement + 32;
        }
        else if(Button == KeyEvent.VK_UP) {
        	System.out.println("keyPressed : haut");
        	//rowIncrement = rowIncrement - 32;
        }
        else if(Button == KeyEvent.VK_DOWN) {
        	System.out.println("keyPressed : bas");
        	//rowIncrement = rowIncrement + 32;            
        }
        /*
        if(isInBounds(rowIncrement, colIncrement)) {
            currentRow += rowIncrement;
            currentCol += colIncrement;
            repaint();
        }*/
    }
    /*
    private boolean isInBounds(int rowIncrement, int colIncrement) {
        int top = currentRow + rowIncrement;
        int left = currentCol + colIncrement;
        int right = left + CHARACTER_WIDTH;
        int bottom = top + CHARACTER_WIDTH;

        return (top >= 0 && left >= 0 && right <= PANEL_SIZE.getWidth() && bottom <= PANEL_SIZE.getHeight());       
    }*/

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {		
	}
	
	public void updatePanel() {
		repaint();
	}
}
