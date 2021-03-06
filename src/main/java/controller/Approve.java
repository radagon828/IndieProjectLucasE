package controller;

import entity.Run;
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
 * this servlet approves a run
 *
 * @author Lucas Eddy
 */
@WebServlet(
        urlPatterns = {"/approve"}
)
public class Approve extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao runDao = new GenericDao(Run.class);

        int runId = Integer.parseInt(req.getParameter("runId"));
        Run run = (Run) runDao.getById(runId);
        run.setApproval("1");
        runDao.saveOrUpdate(run);
        logger.debug("Approving run: ", run);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}