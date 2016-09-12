package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * This is a test class for RequestData.java
 * Created by Lucian on 10/9/2016.
 */
public class RequestDataTest {


    public RequestData requestData;

    @Test
    public void testSurfaceConstructor(){

        requestData = new RequestData();
        int[] coords = new int[2];
        coords[0] = 1;
        coords[1] = 2;
        int[] patch = new int[2];
        patch[0] = 3;
        patch[1] = 4;
        int[] roomSize = new int[2];
        roomSize[0] = 5;
        roomSize[1] = 6;
        List<int[]> patchList = new ArrayList<>();
        patchList.add(patch);

        requestData.setCoords(coords);
        requestData.setRoomSize(roomSize);
        requestData.setInstructions("Instructions");
        requestData.setPatches(patchList);

        assertEquals(1, requestData.getPatches().size());
        assertEquals(3, requestData.getPatches().get(0)[0]);
        assertEquals(4, requestData.getPatches().get(0)[1]);
        assertEquals(1, requestData.getCoords()[0]);
        assertEquals(2, requestData.getCoords()[1]);
        assertEquals("Instructions", requestData.getInstructions());
        assertEquals(5, requestData.getRoomSize()[0]);
        assertEquals(6, requestData.getRoomSize()[1]);
    }
}
