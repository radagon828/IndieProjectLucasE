package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import entity.Game;
import entity.Run;
import entity.RunCategory;
import entity.Technique;
import persistance.GenericDao;

import java.util.List;
import java.util.Set;


@Path("/techniques")
public class FindTech {


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