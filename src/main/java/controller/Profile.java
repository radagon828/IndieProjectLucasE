package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import entity.Run;
import entity.Technique;
import entity.User;
import persistance.GenericDao;

import java.util.List;
import java.util.Set;


@Path("/profiles")
public class Profile {

    @GET
    @Path("{user_name}")
    public void getProfile(@PathParam("user_name") String userName,
                           @Context HttpServletRequest request,
                           @Context HttpServletResponse response) throws Exception
    {
        GenericDao dao = new GenericDao(User.class);

        List<User> userList = dao.getByString("userName", userName);
        User user = userList.get(0);

        Set<Run> runs = user.getRuns();
        Set<Technique> techniques = user.getTechniques();

        request.setAttribute("profile", user);
        request.setAttribute("runs", runs);
        request.setAttribute("techniques", techniques);
        request.getRequestDispatcher("/profile.jsp")
                .forward(request, response);
    }
}
