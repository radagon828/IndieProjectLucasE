package controller;

import entity.Game;
import entity.Technique;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/searchGame"}
)

public class Search extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao gameDao = new GenericDao(Game.class);
        GenericDao techDao = new GenericDao(Technique.class);

        List<Technique> techniques;
        List<Game> games;

        Technique technique = new Technique("Results not found", "Results not found",
                "Results not found", "Results not found", "Resutls not found");
        Game game = new Game("Results not found", "Results not found", "Results not found");

        if (req.getParameter("searchValue") == null || req.getParameter("searchValue") == "") {
            games = new ArrayList<>();
            games.add(game);
            techniques = new ArrayList<>();
            techniques.add(technique);
        } else {
            String searchWord = req.getParameter("searchValue");
            games = gameDao.getByString("title", searchWord);
            techniques = techDao.getByString("title", searchWord);
        }

        logger.debug("Searching based on key:", req.getParameter("searchValue"));

        req.setAttribute("games", games);
        req.setAttribute("techniques", techniques);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}