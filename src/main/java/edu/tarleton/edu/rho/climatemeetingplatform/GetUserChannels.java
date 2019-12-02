/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.HttpSession;

/**
 * Servlet used to get user channels.
 * The list of channels is sent back to the client as a JSON, where it gets
 * processed in JavaScript. 
 * @author Johnny
 */
@WebServlet(name = "GetUserChannels", urlPatterns = {"/GetUserChannels"})
public class GetUserChannels extends HttpServlet {

    @PersistenceContext(unitName="appusers")
    protected EntityManager em;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the current user id from session
        HttpSession session = request.getSession();
        System.out.println(session.toString());
//        Integer userId = ((AppUser)session.getAttribute("user")).getUserId();
        
        // Use a channel manager to get a list of channels with the current
        // user id as a JSON
        AppChannelManager channelManager = new AppChannelManager(em);
        String channels = channelManager.getAppChannelsByOwnerIdAsJSONString(0);
        
        // Write the JSON to the response and send it
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println(channels);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
