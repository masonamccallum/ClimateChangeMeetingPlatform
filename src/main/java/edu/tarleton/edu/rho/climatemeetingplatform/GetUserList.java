package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet used to get a list of users.
 * The list is returned as a JSON object.
 * @author Johnny
 */
@WebServlet(name = "GetUserList", urlPatterns = {"/GetUserList"})
public class GetUserList extends HttpServlet {
    
    @PersistenceContext(unitName="appusers")
    protected EntityManager em;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Use a user manager to get a list of all the users from the database
        // as a JSON object
        AppUserManager userManager = new AppUserManager(em);
        String users = userManager.getAllAppUsersAsJSONString();
        
        // Write the JSON to the response and send it
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(users);
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}
