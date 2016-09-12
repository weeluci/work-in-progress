package controller;

import model.Hoover;
import model.Surface;

/**
 * This class moves the hoover to another position and calls the clean method.
 * Created by Lucian on 10/9/2016.
 */
public class HooverMovements {

    private final char NORTH = 'N';
    private final char SOUTH = 'S';
    private final char EAST = 'E';
    private final char WEST = 'W';

    /**
     * This method moves the hoover to another position and calls the clean method.
     * @param direction this is the new direction of the hoover
     * @param hoover this is the hoover object
     * @param surface this represents the room dimensions
     */
    public void moveAndClean(char direction, Surface surface, Hoover hoover){
        if (direction == NORTH && hoover.getYPosition() != surface.getSurfaceSize()[1]) {
            hoover.setYPosition(hoover.getYPosition() + 1);
        } else if (direction == SOUTH && hoover.getYPosition() != 0) {
            hoover.setYPosition(hoover.getYPosition() - 1);
        } else if (direction == EAST && hoover.getXPosition() != surface.getSurfaceSize()[0]) {
            hoover.setXPosition(hoover.getXPosition() + 1);
        } else if (direction == WEST && hoover.getXPosition() != 0) {
            hoover.setXPosition(hoover.getXPosition() - 1);
        }
        clean(surface, hoover);
    }

    /**
     * This method checks if the hoover matches one of the dirt positions and cleans it.
     * @param surface this is the list of patches
     * @param hoover this is the hoover position
     */
    private void clean(Surface surface, Hoover hoover) {
        for(int[] patch : surface.getPatches()) {
            if (patch[0] == hoover.getXPosition() && patch[1] == hoover.getYPosition()){
                surface.setNumberOfPatches(surface.getNumberOfPatches() - 1);
            }
        }
    }
}
