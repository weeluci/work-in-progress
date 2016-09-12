package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for Hoover.java
 * Created by Lucian on 10/9/2016.
 */
public class HooverTest {

    public Hoover hoover;

    @Test
    public void testHooverConstructor(){

        int[] coords = new int[2];
        coords[0] = 1;
        coords[1] = 1;
        hoover = new Hoover(coords);

        assertEquals(1, hoover.getXPosition());
        assertEquals(1, hoover.getYPosition());
    }

    @Test
    public void testHooverSetters(){

        int[] coords = new int[2];
        coords[0] = 1;
        coords[1] = 1;

        hoover = new Hoover(coords);
        hoover.setXPosition(2);
        hoover.setYPosition(2);

        assertEquals(2, hoover.getXPosition());
        assertEquals(2, hoover.getYPosition());
    }
}
