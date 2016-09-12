package controller;

import model.Hoover;
import model.RequestData;
import model.Response;
import model.Surface;

/**
 * This class is responsible for mapping the RequestData and calls the classes that perform  the cleaning.
 *
 * Created by Lucian on 10/9/2016.
 */
public class Cleaner {

    /**
     * This method maps and calls the cleaning method.
     * @param requestData this is the input data
     * @return the response object
     */
    public Response clean(RequestData requestData) {

        Surface surface = createSurface(requestData);
        Hoover hoover = setStartingPoint(requestData.getCoords());
        String instructions = requestData.getInstructions();

        startCleaning(surface, hoover, instructions);
        return createResponse(surface, hoover);
    }

    /**
     * This method creates a new response.
     * @param surface the surface with number of patches left uncleaned
     * @param hoover the final position of the hoover
     * @return  Response
     */
    public Response createResponse(Surface surface, Hoover hoover) {
        return new Response(surface.getNumberOfPatches(), hoover.getXPosition(), hoover.getYPosition());
    }

    /**
     * This method initialises the Surface with the input data.
     * @param requestData this represents the input data
     * @return a new Surface object
     */
    private Surface createSurface(RequestData requestData) {
        return new Surface(requestData.getRoomSize(), requestData.getPatches());
    }

    /**
     * This method initialises the hoover with the input data.
     * @param coords the input coordinates
     * @return a hoover object
     */
    private Hoover setStartingPoint(int[] coords) {
        return new Hoover(coords);
    }

    /**
     * This method cleans the dirt patch of the hoover location matches.
     * @param surface the surface size
     * @param hoover the hoover object
     * @param instructions hoover instructions
     */
    private void startCleaning(Surface surface, Hoover hoover, String instructions) {

        HooverMovements hooverMovements = new HooverMovements();
        char direction ;
        for (int i = 0; i < instructions.length(); i++){
            direction = instructions.charAt(i);
            hooverMovements.moveAndClean(direction, surface, hoover);
        }
    }
}

