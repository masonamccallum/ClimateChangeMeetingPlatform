package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String channel_ids = request.getParameter("channel_ids");
            List<String> items_s = Arrays.asList(channel_ids.split("\\s*,\\s*"));
            List<Integer> items_i = items_s.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
            Integer items_arr[] = items_i.toArray(new Integer[0]);
            
            System.out.println(items_arr.length);
            
            AppUser appUser = new AppUser(id);
            appUser.setEmail(email);
            appUser.setUsername(username);
            appUser.setOwnedChannelIds(items_i);
//            appUser.setParticipatingChannelIds(items_i);
            
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
