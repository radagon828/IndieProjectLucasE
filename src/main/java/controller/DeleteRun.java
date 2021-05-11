package controller;

import entity.Role;
import entity.Run;
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
 * this servlet deletes a run
 *
 * @author Lucas Eddy
 */
@WebServlet(
        urlPatterns = {"/deleteRun"}
)
public class DeleteRun extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao runDao = new GenericDao(Run.class);

        int runId = Integer.parseInt(req.getParameter("runId"));
        Run run = (Run) runDao.getById(runId);
        String username = run.getUser().getUserName();
        String confirm = req.getParameter("confirm");
        logger.debug("Deletion answer: ", confirm);


        if (confirm.equals("yes")) {
            logger.info("deleted run:", run);
            runDao.delete(run);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}