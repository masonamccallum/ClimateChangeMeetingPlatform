package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet that handles updating channel information.
 * @author Johnny
 */
@WebServlet(name = "UpdateChannel", urlPatterns = {"/UpdateChannel"})
public class UpdateChannel extends HttpServlet {

    @PersistenceContext(unitName="appusers")
    protected EntityManager em;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        // Get new channel information for request
        Integer channelId = Integer.parseInt(request.getParameter("channel_id"));
        String channelName = request.getParameter("channel_name");
        String channelDesc = request.getParameter("channel_desc");
        
        // Use a channel manager to get the corresponding channel from the
        // database
        AppChannelManager channelManager = new AppChannelManager(em);
        AppChannel channel = channelManager.getAppChannelByChannelId(channelId);
        
        // Update the channel in the database, with the new information
        channel.setChannelName(channelName);
        channel.setChannelDesc(channelDesc);
        channelManager.update(channel);
        
        // Redirect back to the main page
        response.sendRedirect("dashboard.jsp");
        
        
    }
}
