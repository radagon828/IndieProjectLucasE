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
        MD5Digest converter = new MD5Digest();

        int userId = Integer.parseInt(req.getParameter("userId"));
        String editParam = req.getParameter("editField");

        User user = (User) userDao.getById(userId);

        if (editParam.equals("name")) {
            user.setUserName(req.getParameter("username"));
        } else if (editParam.equals("email")) {
            user.setUserEmail(req.getParameter("email"));
        } else if (editParam.equals("pass")) {
            String userPass = "";
            try {
                userPass = converter.convertString(req.getParameter("password"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            user.setPassword(userPass);
        }

        userDao.saveOrUpdate(user);
        logger.debug("Edited user:", user);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editProfileSuccess.jsp");
        dispatcher.forward(req, resp);
    }
}