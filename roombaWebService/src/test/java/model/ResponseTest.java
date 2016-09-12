package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for Response.java
 * Created by Lucian on 10/9/2016.
 */
public class ResponseTest {

    public Response response;

    @Test
    public void testSurfaceConstructor(){
        response = new Response(1, 2, 3);
        assertEquals(1, response.getPatches());
        assertEquals(2, response.getCoords()[0]);
        assertEquals(3, response.getCoords()[1]);
    }

    @Test
    public void testSurfaceSetters(){
        response = new Response(2, 2, 2);
        int[] coords = new int[2];
        coords[0] = 1;
        coords[1] = 1;

        response.setCoords(coords);
        response.setPatches(1);

        assertEquals(1, response.getPatches());
        assertEquals(1, response.getCoords()[0]);
        assertEquals(1, response.getCoords()[1]);
    }
}
