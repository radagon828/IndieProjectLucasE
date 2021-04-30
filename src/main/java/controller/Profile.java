package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/profiles")
public class Profile {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    @Path("{user_id}")
    public Response getProfile() {
        // Return a simple message
        String output = "Hello World";

        return Response.status(200).entity(output).build();
    }
}
