package controller;

import model.RequestData;

/**
 * This is a validator class.
 * Created by Lucian on 10/9/2016.
 */
public class Validator {

    /**
     * This method validates the hoover, room size and dirt patches coordinates.
     * @param requestData This is the input data
     * @throws IllegalArgumentException
     */
    public void validateRequest(RequestData requestData) throws IllegalArgumentException {

        if(requestData.getCoords() == null || requestData.getCoords().length != 2){
            throw new IllegalArgumentException("The 'coords' argument must contain an array of 2 integers !");
        }

        if(requestData.getRoomSize() == null || requestData.getRoomSize().length != 2){
            throw new IllegalArgumentException("The 'roomSize' argument must contain an array of 2 integers !");
        }

        if(requestData.getPatches() != null) {
            if(!requestData.getPatches().isEmpty()) {
                for (int[] patch : requestData.getPatches()) {
                    if (patch.length != 2
                                || patch[0] > requestData.getRoomSize()[0] || patch[0] > requestData.getRoomSize()[1]
                                || patch[1] > requestData.getRoomSize()[0] || patch[1] > requestData.getRoomSize()[1]) {
                        throw new IllegalArgumentException("The 'patches' argument must contain a list of arrays with a size of 2 integers !");
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("The 'patches' argument must contain a list of arrays with a size of 2 integers !");
        }
    }
}
