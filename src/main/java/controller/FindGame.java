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
import persistance.GenericDao;

import java.util.*;


/**
 * The type Find game.
 *
 * @author Lucas Eddy
 */
@Path("/games")
public class FindGame {


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
        GenericDao dao = new GenericDao(Game.class);

        List<Game> games = dao.getAll();

        request.setAttribute("games", games);
        request.getRequestDispatcher("/gameList.jsp")
                .forward(request, response);
    }

    /**
     * Gets game.
     *
     * @param request  the request
     * @param response the response
     * @param gameId   the game id
     * @throws Exception the exception
     */
    @GET
    @Path("{game_id}")
    public void getGame(@Context HttpServletRequest request,
                        @Context HttpServletResponse response, @PathParam("game_id") int gameId) throws Exception
    {
        GenericDao dao = new GenericDao(Game.class);

        Game game = (Game) dao.getById(gameId);
        Set<RunCategory> categories = game.getCategories();
        Set<RunCategory> categoriesTwo = game.getCategories();

        request.setAttribute("game", game);
        request.setAttribute("categories", categories);
        request.setAttribute("categoriesTwo", categoriesTwo);
        request.getRequestDispatcher("/gamePage.jsp")
                .forward(request, response);
    }

    /**
     * Gets run submit.
     *
     * @param request  the request
     * @param response the response
     * @param gameId   the game id
     * @throws Exception the exception
     */
    @GET
    @Path("{game_id}/submitRun")
    public void getRunSubmit(@Context HttpServletRequest request,
                        @Context HttpServletResponse response, @PathParam("game_id") int gameId) throws Exception
    {
        GenericDao dao = new GenericDao(Game.class);

        Game game = (Game) dao.getById(gameId);
        Set<RunCategory> categories = game.getCategories();
        request.setAttribute("game", game);
        request.setAttribute("categories", categories);

        request.getRequestDispatcher("/runSubmission.jsp")
                .forward(request, response);
    }

    /**
     * Gets technique submit.
     *
     * @param request  the request
     * @param response the response
     * @param gameId   the game id
     * @throws Exception the exception
     */
    @GET
    @Path("{game_id}/submitTech")
    public void getTechniqueSubmit(@Context HttpServletRequest request,
                             @Context HttpServletResponse response, @PathParam("game_id") int gameId) throws Exception
    {
        GenericDao dao = new GenericDao(Game.class);

        Game game = (Game) dao.getById(gameId);
        request.setAttribute("game", game);

        request.getRequestDispatcher("/techniqueSubmission.jsp")
                .forward(request, response);
    }
}