package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import entity.Run;
import entity.Technique;
import entity.User;
import persistance.GenericDao;

import java.util.List;
import java.util.Set;


/**
 * The type Profile.
 *
 * @author Lucas Eddy
 */
@Path("/profiles")
public class Profile {

    /**
     * Gets profile.
     *
     * @param userName the user name
     * @param request  the request
     * @param response the response
     * @throws Exception the exception
     */
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

    /**
     * Gets edit profile.
     *
     * @param userName the user name
     * @param request  the request
     * @param response the response
     * @throws Exception the exception
     */
    @GET
    @Path("{user_name}/editProfile")
    public void getEditProfile(@PathParam("user_name") String userName,
                           @Context HttpServletRequest request,
                           @Context HttpServletResponse response) throws Exception
    {
        GenericDao dao = new GenericDao(User.class);

        String page;

        List<User> userList = dao.getByString("userName", userName);
        User user = userList.get(0);

        if (user.getUserName().equals(request.getRemoteUser())) {
            page = "/editProfile.jsp";
        } else {
            page = "/general-error.jsp";
        }

        request.setAttribute("profile", user);
        request.getRequestDispatcher(page)
                .forward(request, response);
    }

    /**
     * Gets delete run.
     *
     * @param userName the user name
     * @param runId    the run id
     * @param request  the request
     * @param response the response
     * @throws Exception the exception
     */
    @GET
    @Path("{user_name}/{run_id}/deleteRun")
    public void getDeleteRun(@PathParam("user_name") String userName,
                             @PathParam("run_id") int runId,
                               @Context HttpServletRequest request,
                               @Context HttpServletResponse response) throws Exception
    {
        GenericDao dao = new GenericDao(User.class);

        String page;

        List<User> userList = dao.getByString("userName", userName);
        User user = userList.get(0);

        if (user.getUserName().equals(request.getRemoteUser())) {
            page = "/deleteRun.jsp";
        } else {
            page = "/general-error.jsp";
        }
        request.setAttribute("runId", runId);
        request.setAttribute("profile", user);
        request.getRequestDispatcher(page)
                .forward(request, response);
    }
}
