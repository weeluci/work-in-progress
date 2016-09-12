package model;

import java.util.List;

/**
 * This class that holds the room size and patches data.
 * Created by Lucian on 10/9/2016.
 */
public class Surface {

    private int[] surfaceSize;
    private List<int[]> patches;
    private int numberOfPatches;

    /**
     * This is a constructor for the surface size and number of patches.
     * @param surfaceSize
     * @param patches
     */
    public Surface(int[] surfaceSize, List<int[]> patches) {
        this.surfaceSize = surfaceSize;
        this.patches = patches;
        this.numberOfPatches = patches.size();
    }

    /**
     * This is a getter method for the list of patches.
     * @return the list of patches
     */
    public List<int[]> getPatches() {
        return patches;
    }

    /**
     * This is a setter method for surface.
     * @return set the surface size
     */
    public int[] getSurfaceSize() {
        return surfaceSize;
    }

    /**
     * This is a getter method for the number of patches.
     * @return get the number of patches
     */
    public int getNumberOfPatches() {
        return numberOfPatches;
    }

    /**
     * This is a setter method for the number of patches.
     * @param numberOfPatches set the number of patches
     */
    public void setNumberOfPatches(int numberOfPatches) {
        this.numberOfPatches = numberOfPatches;
    }

}

