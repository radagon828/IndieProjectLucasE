package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import entity.User;
import persistance.GenericDao;


@Path("/profiles")
public class Profile {

    @GET
    @Path("{user_id}")
    public void getProfile(@PathParam("user_id") int userId,
                           @Context HttpServletRequest request,
                           @Context HttpServletResponse response) throws Exception
    {
        GenericDao dao = new GenericDao(User.class);

        User user = (User) dao.getById(userId);

        request.setAttribute("profile", user);
        request.getRequestDispatcher("/profile.jsp")
                .forward(request, response);
    }
}
