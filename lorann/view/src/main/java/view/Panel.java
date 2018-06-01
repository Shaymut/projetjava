package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import model.*;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Panel extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
    private static Dimension PANEL_SIZE;
    private static final int TILE_SIZE = 32;
    private static final int REFRESH_RATE = 250;
    private static final int CHARACTER_WIDTH = 32;
    
    Image Image;
    
    private Timer timer = new Timer(REFRESH_RATE, this);
    private int currentRow = 0;
    private int currentCol = 0;
    private int randomRow = 0;
    private int randomCol = 0;
    
    Element[][] mapNiveau;
    
    Image image;

    public Panel(int x, int y, Element[][] mapNiveau) {
    	Panel.PANEL_SIZE = new Dimension(x*TILE_SIZE, y*TILE_SIZE);
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
        
        g.drawOval(randomCol, randomRow, CHARACTER_WIDTH, CHARACTER_WIDTH);
        g.drawRect(currentCol, currentRow, CHARACTER_WIDTH, CHARACTER_WIDTH);
        
        //System.out.println(String.valueOf(mapNiveau[0][0].getSprite()));
        /*try {
			image = ImageIO.read(new File(getClass().getResource("/pictures/bone.png").toURI()));
			g.drawImage(image, 50, 50, this);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        
        /*switch(mapNiveau[0][0].getSprite()) {
        case 'S':
        	try {
				image = ImageIO.read(new File(getClass().getResource("/pictures/bone.png").toURI()));
				g.drawImage(image, 50, 50, this);
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
        	break;
        case 'H' :
        	try {
				image = ImageIO.read(new File(getClass().getResource("/pictures/bone.png").toURI()));
				g.drawImage(image, 50, 50, this);
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
        	break;
        case 'V' :
        	try {
				image = ImageIO.read(new File(getClass().getResource("/pictures/bone.png").toURI()));
				g.drawImage(image, 50, 50, this);
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
        	break;
        case 'X' :
        	try {
				image = ImageIO.read(new File(getClass().getResource("/pictures/bone.png").toURI()));
				g.drawImage(image, 50, 50, this);
			} catch (IOException | URISyntaxException e) {
				e.printStackTrace();
			}
        	break;
        }*/
		
        
    }

    public void actionPerformed(ActionEvent e) {
        int min = 0;
        int maxRow = (int)PANEL_SIZE.getHeight() - CHARACTER_WIDTH;
        int maxCol =  (int)PANEL_SIZE.getWidth() - CHARACTER_WIDTH;

        Random rand = new Random();
        randomRow = rand.nextInt((maxRow - min) + 1) + min;
        randomCol = rand.nextInt((maxCol - min) + 1) + min;

        repaint();
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
}