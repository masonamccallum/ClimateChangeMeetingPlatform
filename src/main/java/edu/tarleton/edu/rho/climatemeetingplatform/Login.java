/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Johnny
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    @PersistenceContext(unitName="appusers")
    protected EntityManager em;
    
    protected void setUserSession(HttpServletRequest request, AppUser user) {
        // Create a session object if it is already not created.
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String username = (String)request.getParameter("username").strip();  
        System.out.println("username: " + username);
        try {
           AppUserManager userManager = new AppUserManager(em);
           AppUser user = userManager.getAppUserByUsername(username);
           user.setEmail("test1");
           userManager.update(user);
           setUserSession(request, user);
           System.out.println(user.toString());

         } catch (Exception ex){
             Logger.getLogger(AppUser.class.getName()).log(Level.SEVERE, null, ex);
         }

      
        // Set response content type
        response.setContentType("text/html");

        // New location to be redirected
        String site = new String("dashboard.jsp");

        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site); 
    }
}
