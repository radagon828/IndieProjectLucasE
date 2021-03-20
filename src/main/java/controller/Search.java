package controller;

import entity.Run;
import persistance.GenericDao;

import java.io.*;
import java.util.List;
import javax.servlet.annotation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author Lucas Eddy
 *
 */
@WebServlet(
        name = "search",
        urlPatterns = { "/search" }
)
public class Search extends HttpServlet {

//    private GenericDao dao;
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request                   the HttpServletRequest object
     *@param  response                   the HttpServletResponse object
     *@exception  ServletException  if there is a Servlet failure
     *@exception  IOException       if there is an IO failure
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        dao = new GenericDao(Run.class);
//        List<Run> runs = dao.getAll();
//        request.setAttribute("recentRuns", runs);
//
//        String url = "/index.jsp";
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
//        dispatcher.forward(request, response);
    }
}