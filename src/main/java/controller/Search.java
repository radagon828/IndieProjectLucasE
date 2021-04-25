package controller;

import entity.Game;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao gameDao;
        gameDao = new GenericDao(Game.class);

        List<Game> games;
        Game game = new Game("Results not found", "Results not found", "Results not found");

        if (req.getParameter("searchValue") == null || req.getParameter("searchValue") == "") {
            games = new ArrayList<>();
            games.add(game);
        } else {
            String searchWord = req.getParameter("searchValue");
            games = gameDao.getByString("title", searchWord);
        }
        req.setAttribute("games", games);

        req.setAttribute("newValue", "hello this is a test");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}