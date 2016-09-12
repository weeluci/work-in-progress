package model;

import org.junit.Test;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * This is a test class for MainResponse.java
 * Created by Lucian on 10/9/2016.
 */
public class MainResponseTest {

    public MainResponse mainResponse;

    @Test
         public void testMainResponseConstructor(){
        Response mockResponse = mock(Response.class);

        mainResponse = new MainResponse(mockResponse, "Instructions");

        assertEquals("Instructions", mainResponse.getErrorMessage());
        assertNotNull(mainResponse.getResponse());
    }

    @Test
    public void testMainResponseSetters(){
        Response mockResponse = mock(Response.class);

        mainResponse = new MainResponse(mockResponse, "Instructions");
        mainResponse.setErrorMessage("New instructions");
        mainResponse.setResponse(mock(Response.class));

        assertEquals("New instructions", mainResponse.getErrorMessage());
        assertThat(mockResponse, not(mainResponse.getResponse()));
    }
}
