package controller;

import entity.User;
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

/**
 * this servlet edits a current user
 *
 * @author Lucas Eddy
 */
@WebServlet(
        urlPatterns = {"/editProfile"}
)
public class EditProfile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        GenericDao userDao = new GenericDao(User.class);

        int userId = Integer.parseInt(req.getParameter("userId"));

        User user = (User) userDao.getById(userId);
        user.setUserEmail(req.getParameter("email"));

        userDao.saveOrUpdate(user);
        logger.debug("Edited user:", user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}