package controller;

import entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * this servlet adds a new user
 *
 * @author Lucas Eddy
 */
@WebServlet(
        urlPatterns = {"/submitTech"}
)
public class SubmitTech extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        GenericDao techDao = new GenericDao(Run.class);
        GenericDao userDao = new GenericDao(User.class);
        GenericDao gameDao = new GenericDao(Game.class);

        List<User> userList = userDao.getByString("userName", req.getRemoteUser());
        User user = userList.get(0);

        int gameId = Integer.parseInt(req.getParameter("gameId"));
        Game game = (Game)gameDao.getById(gameId);

        Technique newTech = new Technique(req.getParameter("videoTitle"), req.getParameter("description"),
                req.getParameter("videoType"), req.getParameter("videoLink"), "" + formatter.format(date) + "");
        game.addTechnique(newTech);
        user.addTechnique(newTech);
        techDao.insert(newTech);

        logger.debug("Adding new tech:", newTech);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/submissionSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
