package model;

/**
 * This is the hoover class.
 * Created by Lucian on 10/9/2016.
 */
public class Hoover {

    private int xPosition;
    private int yPosition;

    /**
     * This is a constructor for the Hoover
     * @param coords input hoover coordinates
     */
    public Hoover(int[] coords) {
        xPosition = coords[0];
        yPosition = coords[1];
    }

    /**
     * This is a getter method for X hoover postion
     * @return
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * This is a setter method for X hoover postion
     * @param xPosition
     */
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * This is a getter method for X hoover postion
     * @return
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * This is a setter method for Y hoover postion
     * @param yPosition
     */
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

}