package controller;

import model.Hoover;
import model.RequestData;
import model.Response;
import model.Surface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This is a test class for Cleaner.java.
 * Created by Lucian on 10/9/2016.
 */
public class CleanerTest {

    public Cleaner cleaner;

    @Before
    public void setUp(){
        cleaner = new Cleaner();
    }

    @Test
    public void testCreateResponse(){
        Surface mockSurface = mock(Surface.class);
        Hoover mockHoover = mock(Hoover.class);
        when(mockSurface.getNumberOfPatches()).thenReturn(1);
        when(mockHoover.getXPosition()).thenReturn(1);
        when(mockHoover.getYPosition()).thenReturn(1);

        assertNotNull(cleaner.createResponse(mockSurface, mockHoover));
    }

    @Test
    public void testClean(){

        List<int[]> patchList = new ArrayList<>();
        int[] coords = new int[2];
        coords[0] = 1;
        coords[1] = 2;
        int[] firstPatch = new int[2];
        firstPatch[0] = 0;
        firstPatch[1] = 1;
        int[] roomSize = new int[2];
        roomSize[0] = 5;
        roomSize[1] = 5;
        patchList.add(firstPatch);

        RequestData mockRequestData = mock(RequestData.class);

        when(mockRequestData.getCoords()).thenReturn(coords);
        when(mockRequestData.getPatches()).thenReturn(patchList);
        when(mockRequestData.getRoomSize()).thenReturn(roomSize);
        when(mockRequestData.getInstructions()).thenReturn("NNSEWNS");

        Response response = cleaner.clean(mockRequestData);
        assertNotNull(response);
        assertEquals(1, response.getPatches());
        assertEquals(1, response.getCoords()[0]);
        assertEquals(3, response.getCoords()[1]);
    }
}
