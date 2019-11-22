/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Johnny
 */
@WebServlet(name = "CreateChannel", urlPatterns = {"/CreateChannel"})
public class CreateChannel extends HttpServlet {

    @PersistenceContext(unitName="appusers")
    protected EntityManager em;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Get our parameters from the request and create a new AppChannel
            HttpSession session = request.getSession();
            
            Integer ownerId = ((AppUser)session.getAttribute("user")).userId;
            String channelName = request.getParameter("channel_name");
            String channelDesc = request.getParameter("channel_desc");
            
            AppChannel channel = new AppChannel();
            channel.setOwnerId(ownerId);
            channel.setChannelName(channelName);
            channel.setChannelDesc(channelDesc);
            AppChannelManager channelManager = new AppChannelManager(em);
            channelManager.persist(channel);
            
            // Redirect back to the main page
            response.sendRedirect("dashboard.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AddEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
