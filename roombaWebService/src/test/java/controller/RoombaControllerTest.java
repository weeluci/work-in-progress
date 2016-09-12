package controller;

import model.RequestData;
import org.junit.Test;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * This is a test class for Cleaner.java.
 * Created by Lucian on 10/9/2016.
 */
public class RoombaControllerTest {

    RoombaController controller;

    @Test
    public void testHooverThrowsIllegalArgumentException(){
        controller = new RoombaController();
        RequestData mockRequestData = mock(RequestData.class);
        Validator mockValidator = mock(Validator.class);
        IllegalArgumentException mockException = mock(IllegalArgumentException.class);
        doThrow(mockException).when(mockValidator).validateRequest(mockRequestData);

        Response response = controller.hoover(mockRequestData);
        assertEquals(400, response.getStatus());
    }

    @Test
    public void testHoover(){

        List<int[]> patchList = new ArrayList<>();
        int[] coords = new int[2];
        coords[0] = 1;
        coords[1] = 2;
        int[] firstPatch = new int[2];
        firstPatch[0] = 1;
        firstPatch[1] = 0;
        int[] roomSize = new int[2];
        roomSize[0] = 5;
        roomSize[1] = 5;
        patchList.add(firstPatch);
        controller = new RoombaController();
        RequestData mockRequestData = mock(RequestData.class);
        when(mockRequestData.getRoomSize()).thenReturn(roomSize);
        when(mockRequestData.getInstructions()).thenReturn("NWSNWSSEW");
        when(mockRequestData.getPatches()).thenReturn(patchList);
        when(mockRequestData.getCoords()).thenReturn(coords);

        Response response = controller.hoover(mockRequestData);
        assertEquals(200, response.getStatus());
    }

}
