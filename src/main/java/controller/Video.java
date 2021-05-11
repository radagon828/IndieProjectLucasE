package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import entity.Run;
import entity.Technique;
import persistance.GenericDao;


/**
 * The type Video.
 *
 * @author Lucas Eddy
 */
@Path("/videos")
public class Video {

    /**
     * Gets tech.
     *
     * @param request  the request
     * @param response the response
     * @param videoId  the video id
     * @throws Exception the exception
     */
    @GET
    @Path("tech/{video_id}")
    public void getTech(@Context HttpServletRequest request,
            @Context HttpServletResponse response, @PathParam("video_id") int videoId) throws Exception
    {
        GenericDao dao = new GenericDao(Technique.class);

        Technique tech = (Technique) dao.getById(videoId);

        request.setAttribute("videoDisplay", tech);
        request.getRequestDispatcher("/video.jsp")
                .forward(request, response);
    }

    /**
     * Gets run.
     *
     * @param request  the request
     * @param response the response
     * @param videoId  the video id
     * @throws Exception the exception
     */
    @GET
    @Path("run/{video_id}")
    public void getRun(@Context HttpServletRequest request,
                       @Context HttpServletResponse response, @PathParam("video_id") int videoId) throws Exception
    {
        GenericDao dao = new GenericDao(Run.class);

        Run run = (Run) dao.getById(videoId);

        request.setAttribute("videoDisplay", run);
        request.getRequestDispatcher("/video.jsp")
                .forward(request, response);
    }
}