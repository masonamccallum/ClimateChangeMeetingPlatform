package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet that handles login.
 * This servlet sets the clients session current user and loads necessary 
 * information from the database to populate the dashboard page.
 * @author Johnny
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    @PersistenceContext(unitName="appusers")
    protected EntityManager em;
    
    protected void setUserSession(HttpServletRequest request, AppUser user) {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String username = (String)request.getParameter("username").strip(); 
        try {
            // User a user manager to load a user from the database 
            AppUserManager userManager = new AppUserManager(em);
            AppUser user = userManager.getAppUserByUsername(username);
            
            System.out.println("User:" + user.toString());
            
            // Create a session object if it is already not created.
            HttpSession session = request.getSession(true);

            // Set the session's current user
            session.setAttribute("user", user);

            Integer userId = ((AppUser)session.getAttribute("user")).getUserId();
            System.out.println("userId: " + userId);

         } catch (Exception ex){
            Logger.getLogger(AppUser.class.getName()).log(Level.SEVERE, null, ex);
         }

      
        // Set response content type
        response.setContentType("text/html");

        // New location to be redirected
        String site = "dashboard.jsp";

        // Send redirect
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site); 
    }
}
