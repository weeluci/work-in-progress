package model;

import java.util.List;

/**
 * This class that holds the input data.
 * Created by Lucian on 10/9/2016.
 */
public class RequestData {

    private int[] roomSize;
    private int[] coords;
    private List<int[]> patches;
    private String instructions;

    /**
     * Introducing the dummy constructor
     */
    public RequestData() {}

    /**
     * This is a getter method for room size
     * @return the room size
     */
    public int[] getRoomSize() {
        return roomSize;
    }

    /**
     * This is a setter method for room size
     * @param roomSize set the room size
     */
    public void setRoomSize(int[] roomSize) {
        this.roomSize = roomSize;
    }

    /**
     * This is a getter method for Coords.
     * @return get the coords
     */
    public int[] getCoords() {
        return coords;
    }

    /**
     * This is a setter method for Coords.
     * @param coords set the coords
     */
    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    /**
     * This is a getter method for Patches.
     * @return the list of Patches
     */
    public  List<int[]> getPatches() {
        return patches;
    }

    /**
     * This is a setter method for Patches.
     * @param patches the list of Patches
     */
    public void setPatches( List<int[]> patches) {
        this.patches = patches;
    }

    /**
     * This is a getter method for Instructions.
     * @return returns the hoover instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * This is a setter method for Instructions.
     * @param instructions the hoover instructions to be set
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
