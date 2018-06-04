package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;*/
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
    private static Dimension PANEL_SIZE;
    
    Image Image;
    
    Element[][] mapNiveau;
    
    BufferedImage image = null;
    
   

    public Panel(int x, int y, Element[][] mapNiveau) {
    	Panel.PANEL_SIZE = new Dimension(x, y);
    	this.mapNiveau = mapNiveau;
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    
    public void setMap(Element[][] mapNiveau) {
    	this.mapNiveau = mapNiveau;
    	repaint();
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
        				image = ImageIO.read(new File(getClass().getResource("/pictures/bone.png").toURI()));
        				break;
        			case 'H':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/horizontal_bone.png").toURI()));
        				break;
        			case 'V':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/vertical_bone.png").toURI()));
        				break;
        			case 'X':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/ground.png").toURI()));
        				break;
        			case 'L':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/lorann_6.png").toURI()));
        				break;
        			case 'G':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/purse.png").toURI()));
        				break;
        			case 'E':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/crystal_ball.png").toURI()));
        				break;
        			case 'P':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/fireball_1.png").toURI()));
        				break;
        			case 'F':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/monster_1.png").toURI()));
        				break;
        			case 'K':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/monster_2.png").toURI()));
        				break;
        			case 'B':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/monster_3.png").toURI()));
        				break;
        			case 'J':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/monster_4.png").toURI()));
        				break;
        			case 'C':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/gate_closed.png").toURI()));
        				break;
        			case 'O':
        				image = ImageIO.read(new File(getClass().getResource("/pictures/gate_open.png").toURI()));
        				break;
        			}
        			g.drawImage(image, i*32, j*32, this);
        		} catch (IOException | URISyntaxException e) {
        			e.printStackTrace();
        		}
        	}
        }
    }
    
    
    public void updatePanel() {
		repaint();
	}

    
}
    
