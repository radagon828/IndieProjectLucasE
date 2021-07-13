package controller;

import entity.Role;
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
 * this servlet adds a new user
 *
 * @author Lucas Eddy
 */
@WebServlet(
        urlPatterns = {"/signUp"}
)
public class SignUp extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao userDao = new GenericDao(User.class);

        User user = new User();
        user.setUserName(req.getParameter("username"));
        user.setUserEmail(req.getParameter("email"));

        //secure password
        user.setPassword(req.getParameter("password"));

        Role role = new Role("user", user.getUserName());

        user.addRole(role);

        userDao.insert(user);

        logger.debug("Added user:", user);

        req.setAttribute("newUserId", user.getId());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUpSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}
