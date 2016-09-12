package model;

/**
 * This class that holds response data.
 * Created by Lucian on 10/9/2016.
 */
public class Response {

    int[] coords = new int[2];
    int patches;

    /**
     * This is a Response constructor.
     * @param noOfPatches the number of patches left uncleaned
     * @param xHooverPosition the x position of the hoover
     * @param yHooverPosition the y position of the hoover
     */
	public Response(int noOfPatches, int xHooverPosition, int yHooverPosition) {
        coords[0] = xHooverPosition;
        coords[1] = yHooverPosition;

    	patches = noOfPatches;
    }

    /**
     * This is a getter method for coords.
	 * @return the coords
	 */
	public int[] getCoords() {
		return coords;
	}

	/**
     * This is a setter method for coords.
	 * @param coords the coords to set
	 */
	public void setCoords(int[] coords) {
		this.coords = coords;
	}

	/**
     * This is a getter method for patches.
	 * @return the patches
	 */
	public int getPatches() {
		return patches;
	}

	/**
     * This is a setter method for patches.
	 * @param patches the patches to set
	 */
	public void setPatches(int patches) {
		this.patches = patches;
	}
}