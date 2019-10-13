package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

/**
 * @author Johnny
 */
@WebServlet(name = "AddEntry", urlPatterns = {"/AddEntry"})
public class AddEntry extends HttpServlet {

    @PersistenceContext(unitName="appusers")
    public EntityManager em;
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Get our paramets from the request and create a new AppUser
            Integer id = Integer.parseInt(request.getParameter("id"));
            String userName = request.getParameter("username");
            String email = request.getParameter("email");
            
            AppUser appUser = new AppUser(id, userName, email);
            
            // Get the current JTA transaction handler and begin a new transaction
            UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            
            // Persit our new AppUser object (send it to the database)
            em.persist(appUser);
            
            // Commit our transaction
            transaction.commit();
            
            // Redirect back to the main page
            response.sendRedirect(request.getContextPath());
        } catch (Exception ex) {
            Logger.getLogger(AddEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
