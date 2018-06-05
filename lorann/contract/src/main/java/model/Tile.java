package model;

/**
 * <h1>The Class Tile.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class Tile {

    /** The id. */
    private final int id;

    /** The sprite. */
    private char sprite;
    
    /** The x. */
    private int x;
    
    /** The y. */
    private int y;
    
    /** The IDMap. */
    private int IDMap;

    /**
     * Instantiates a new tile.
     *
     * @param id
     *            the id
     * @param sprite
     *            the sprite
     * @param x
     *            the x
     * @param y
     *            the y
     * @param IDMap
     *            the IDMap
     */
    public Tile(final int id, final char sprite, final int x, final int y, final int IDMap) {
        super();
        this.id = id;
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.IDMap = IDMap;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    public char getSprite() {
        return this.sprite;
    }

    /**
     * Sets the sprite.
     *
     * @param sprite
     *            the new sprite
     */
    public void setSprite(final char sprite) {
        this.sprite = sprite;
    }
    
    /**
     * Gets the x.
     *
     * @return the x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public void setX(final int x) {
        this.x = x;
    }
    
    /**
     * Gets the y.
     *
     * @return the y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the y.
     *
     * @param y
     *            the new y
     */
    public void setY(final int y) {
        this.y = y;
    }
    
    /**
     * Gets the IDMap.
     *
     * @return the IDMap
     */
    public int getIDMap() {
        return this.IDMap;
    }

    /**
     * Sets the IDMap.
     *
     * @param IDMap
     *            the new IDMap
     */
    public void setIDMap(final int IDMap) {
        this.IDMap = IDMap;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getId() + " : " + this.getSprite() + " : " + this.getX() + " : " + this.getY() + " : " + this.getIDMap();
    }
    
}
