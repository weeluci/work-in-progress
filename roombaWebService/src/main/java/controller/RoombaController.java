package controller;

import model.MainResponse;
import model.RequestData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This is a controller class for the Roomba web service
 * Created by Lucian on 9/5/2016.
 */
@RestController
@RequestMapping("/")
public class RoombaController {

    @Consumes(MediaType.APPLICATION_JSON)
    @RequestMapping(value = "/hoover", method = RequestMethod.POST, headers="Accept=application/json")
    public Response hoover(@RequestBody RequestData requestData) {
        Validator validator = new Validator();
        try {
            validator.validateRequest(requestData);
        } catch (IllegalArgumentException e){
            return Response.status(400).entity(new MainResponse(null, e.getMessage())).build();
        }
        Cleaner cleaner = new Cleaner();
        return Response.status(200).entity(new MainResponse(cleaner.clean(requestData), null)).build();
    }
}
