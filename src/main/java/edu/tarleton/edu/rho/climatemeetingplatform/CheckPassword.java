package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
 *
 * @author Johnny
 */
@WebServlet(name = "CheckPassword", urlPatterns = {"/CheckPassword"})
public class CheckPassword extends HttpServlet {

    @PersistenceContext(unitName="appusers")
    protected EntityManager em;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        
        try {       
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            AppUserManager userManager = new AppUserManager(em);
            AppUser user = userManager.getAppUserByUsername(username);
            
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            	
            byte[] hashedPassword = md.digest(password.getBytes());
            String temp = hashedPassword.toString();
//            System.out.println(temp);
//            System.out.println(user.getPassword());
//            
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            if(true) {
                try (PrintWriter out = response.getWriter()) {
                    out.println("success");
                }
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("failure");    
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CheckPassword.class.getName()).log(Level.SEVERE, null, ex);

        }

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
