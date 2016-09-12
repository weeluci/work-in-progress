package model;

/**
 * This class represents the main response being returned.
 * Created by Lucian on 10/9/2016.
 */
public class MainResponse {

    private Response response;
    private String errorMessage;

    /**
     * This is a constructor for the main Response.
     * @param response
     * @param errorMessage
     */
    public MainResponse (Response response, String errorMessage){
        this.response = response;
        this.errorMessage = errorMessage;
    }

    /**
     * This is a getter method for ErrorMessage.
     * @return  the error message to be returned
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * This is a setter method for ErrorMessage.
     * @param errorMessage  the error message to be set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * This is a getter method for Response.
     * @return the response to be returned
     */
    public Response getResponse() {
        return response;
    }

    /**
     * This is a setter method for Response.
     * @param response the response to be set
     */
    public void setResponse(Response response) {
        this.response = response;
    }

}
