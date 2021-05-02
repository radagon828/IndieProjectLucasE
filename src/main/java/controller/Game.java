package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import persistance.GenericDao;

import java.util.List;


@Path("/games")
public class Game {

    @GET
    public void getGames(@Context HttpServletRequest request,
                        @Context HttpServletResponse response) throws Exception
    {
        GenericDao dao = new GenericDao(Game.class);

        List<Game> games = dao.getAll();

        request.setAttribute("games", games);
        request.getRequestDispatcher("/gamesList.jsp")
                .forward(request, response);
    }

    @GET
    @Path("{game_id}")
    public void getGame(@Context HttpServletRequest request,
                        @Context HttpServletResponse response, @PathParam("game_id") int gameId) throws Exception
    {
        GenericDao dao = new GenericDao(Game.class);

        Game game = (Game) dao.getById(gameId);

        request.setAttribute("game", game);
        request.getRequestDispatcher("/gamePage.jsp")
                .forward(request, response);
    }


}