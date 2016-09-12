package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for Surface.java
 * Created by Lucian on 10/9/2016.
 */
public class SurfaceTest {

    private Surface surface;

    @Test
    public void testSurfaceConstructor(){
        int[] surfaceSize = new int[2];
        List<int[]> patches = new ArrayList<>();
        surface = new Surface(surfaceSize, patches);
        assertEquals(0, surface.getNumberOfPatches());
        assertEquals(0, surface.getPatches().size());
        assertEquals(2, surface.getSurfaceSize().length);
        surface.setNumberOfPatches(3);
        assertEquals(3, surface.getNumberOfPatches());
    }

}
