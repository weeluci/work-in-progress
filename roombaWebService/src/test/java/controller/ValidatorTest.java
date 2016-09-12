package controller;

import model.RequestData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This is a test class for Validator.java
 * Created by Lucian on 10/9/2016.
 */
public class ValidatorTest {

    public Validator validator;

    public RequestData mockRequestData;

    @Before
    public void setUp() {
        validator = new Validator();
        mockRequestData = mock(RequestData.class);
    }

    @Test
    public void testValidateRequestWithNullCoordinates() {

        when(mockRequestData.getCoords()).thenReturn(null);

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'coords' argument must contain an array of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithNullRoomSize() {

        when(mockRequestData.getCoords()).thenReturn(new int[2]);
        when(mockRequestData.getRoomSize()).thenReturn(null);

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'roomSize' argument must contain an array of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithNullPatches() {

        when(mockRequestData.getRoomSize()).thenReturn(new int[2]);
        when(mockRequestData.getCoords()).thenReturn(new int[2]);
        when(mockRequestData.getPatches()).thenReturn(null);

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'patches' argument must contain a list of arrays with a size of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithEmptyCoordinatesArray() {

        when(mockRequestData.getCoords()).thenReturn(new int[0]);

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'coords' argument must contain an array of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithEmptyRoomSizeArray() {

        when(mockRequestData.getRoomSize()).thenReturn(new int[0]);
        when(mockRequestData.getCoords()).thenReturn(new int[2]);

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'roomSize' argument must contain an array of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithEmptyPatchArrays() {


        when(mockRequestData.getRoomSize()).thenReturn(new int[2]);
        when(mockRequestData.getCoords()).thenReturn(new int[2]);
        when(mockRequestData.getPatches()).thenReturn(Arrays.asList(new int[0], new int[0]));

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'patches' argument must contain a list of arrays with a size of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithEmptyPatchList() {


        when(mockRequestData.getRoomSize()).thenReturn(new int[2]);
        when(mockRequestData.getCoords()).thenReturn(new int[2]);
        when(mockRequestData.getPatches()).thenReturn(new ArrayList<int[]>());

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'patches' argument must contain a list of arrays with a size of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithInvalidYPatches() {

        int[] patch = new int[2];
        patch[0] = 3;
        patch[1] = 4;
        when(mockRequestData.getRoomSize()).thenReturn(createRoomSize());
        when(mockRequestData.getCoords()).thenReturn(new int[2]);
        when(mockRequestData.getPatches()).thenReturn(Arrays.asList(patch, patch));

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'patches' argument must contain a list of arrays with a size of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithInvalidXPatches() {

        int[] patch = new int[2];
        patch[0] = 4;
        patch[1] = 3;
        when(mockRequestData.getRoomSize()).thenReturn(createRoomSize());
        when(mockRequestData.getCoords()).thenReturn(new int[2]);
        when(mockRequestData.getPatches()).thenReturn(Arrays.asList(patch, patch));

        try {
            validator.validateRequest(mockRequestData);
        } catch (IllegalArgumentException e) {
            assertEquals("The 'patches' argument must contain a list of arrays with a size of 2 integers !", e.getMessage());
        }
    }

    @Test
    public void testValidateRequestWithValidPatches() {

        int[] patch = new int[2];
        patch[0] = 2;
        patch[1] = 3;

        when(mockRequestData.getRoomSize()).thenReturn(createRoomSize());
        when(mockRequestData.getCoords()).thenReturn(new int[2]);
        when(mockRequestData.getPatches()).thenReturn(Arrays.asList(patch, patch));

        validator.validateRequest(mockRequestData);
    }

    private int[] createRoomSize() {
        int[] roomSize = new int[2];
        roomSize[0] = 3;
        roomSize[1] = 3;
        return roomSize;
    }
}
