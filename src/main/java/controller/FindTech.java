package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import entity.Technique;
import persistance.GenericDao;

import java.util.List;


/**
 * The type Find tech.
 *
 * @author Lucas Eddy
 */
@Path("/techniques")
public class FindTech {


    /**
     * Gets games.
     *
     * @param request  the request
     * @param response the response
     * @throws Exception the exception
     */
    @GET
    public void getGames(@Context HttpServletRequest request,
                         @Context HttpServletResponse response) throws Exception
    {
        GenericDao dao = new GenericDao(Technique.class);

        List<Technique> techniques = dao.getAll();

        request.setAttribute("techniques", techniques);
        request.getRequestDispatcher("/techVideos.jsp")
                .forward(request, response);
    }

}