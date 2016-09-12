package controller;

import model.Hoover;
import model.Surface;
import org.junit.Test;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This is a test class for HooverMovements.java.
 * Created by Lucian on 9/11/2016.
 */
public class HooverMovementsTest {

    @Spy
    private HooverMovements hooverMovements;

    @Test
    public void testMoveAndClean(){

        hooverMovements = new HooverMovements();
        Surface mockSurface = mock(Surface.class);
        Hoover mockHoover = mock(Hoover.class);
        List<int[]> patchList = new ArrayList<>();
        int[] firstPatch = new int[2];
        firstPatch[0] = 1;
        firstPatch[1] = 0;
        int[] secondPatch = new int[2];
        secondPatch[0] = 2;
        secondPatch[1] = 2;
        int[] thirdPatch = new int[2];
        thirdPatch[0] = 2;
        thirdPatch[1] = 3;
        int[] surfaceSize = new int[2];
        surfaceSize[0] = 5;
        surfaceSize[1] = 5;
        patchList.add(firstPatch);
        patchList.add(secondPatch);
        patchList.add(thirdPatch);

        when(mockSurface.getPatches()).thenReturn(patchList);
        when(mockSurface.getNumberOfPatches()).thenReturn(1);
        when(mockSurface.getSurfaceSize()).thenReturn(surfaceSize);
        when(mockHoover.getXPosition()).thenReturn(1);
        when(mockHoover.getYPosition()).thenReturn(3);
        String instructions = "NNESEESWNWW";


        assertEquals(1, mockSurface.getNumberOfPatches());
        assertEquals(1, mockHoover.getXPosition());
        assertEquals(3, mockHoover.getYPosition());
    }

    @Test
    public void testMoveAndCleanWithoutMocks(){

        hooverMovements = new HooverMovements();
        List<int[]> patchList = new ArrayList<>();
        int[] coords = new int[2];
        coords[0] = 1;
        coords[1] = 2;
        int[] firstPatch = new int[2];
        firstPatch[0] = 1;
        firstPatch[1] = 0;
        int[] secondPatch = new int[2];
        secondPatch[0] = 2;
        secondPatch[1] = 2;
        int[] thirdPatch = new int[2];
        thirdPatch[0] = 2;
        thirdPatch[1] = 3;
        int[] surfaceSize = new int[2];
        surfaceSize[0] = 5;
        surfaceSize[1] = 5;
        patchList.add(firstPatch);
        patchList.add(secondPatch);
        patchList.add(thirdPatch);
        Hoover hoover = new Hoover(coords);
        Surface surface = new Surface(surfaceSize, patchList);

        String instructions = "NNESEESWNWW";

        char direction ;
        for (int i = 0; i < instructions.length(); i++){
            direction = instructions.charAt(i);
            hooverMovements.moveAndClean(direction, surface, hoover);
        }

        assertEquals(1, surface.getNumberOfPatches());
        assertEquals(1, hoover.getXPosition());
        assertEquals(3, hoover.getYPosition());
    }
}
