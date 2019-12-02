package edu.tarleton.edu.rho.climatemeetingplatform;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import org.json.JSONObject;

/**
 * The AppChannelManager handles channel queries and transactions to and from the database.
 * 
 * @author Johnny
 */
public class AppChannelManager {
    
    protected EntityManager em;

    public AppChannelManager(EntityManager em) {
        this.em = em;
    }
    
    public AppChannel getAppChannelByChannelId(Integer id) {
        return em.createNamedQuery("AppChannel.findByChannelId", AppChannel.class)
                .setParameter("channelId", id)
                .getResultList().get(0);
    }
    
    public List<AppChannel> getAppChannelsByOwnerId(Integer id) {
        return em.createNamedQuery("AppChannel.findByOwnerId", AppChannel.class)
                .setParameter("ownerId", id)
                .getResultList();
    }
    
    public String getAppChannelsByOwnerIdAsJSONString(Integer id) {
        List<AppChannel> channels = em.createNamedQuery("AppChannel.findByOwnerId", AppChannel.class)
                .setParameter("ownerId", id)
                .getResultList();
        
        ListIterator<AppChannel> it = channels.listIterator();
        List<JSONObject> jsonStrings = new ArrayList<>();
        for (AppChannel channel : channels) {
            jsonStrings.add(channel.toInfoJson());
        }
        
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("user_id", id);
        jsonObj.put("channels", jsonStrings);
        return jsonObj.toString();
    }
        
    protected void update(AppChannel appChannel) {
        Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Attempting to update " + appChannel);
        try {
            //Get the current JTA transaction handler and begin a new transaction
            UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            
            // Persit our AppUser object (send it to the database)
            em.merge(appChannel);
            
            // Commit our transaction
            transaction.commit();
            Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Update successeful!");
        } catch (Exception ex) {
            System.out.println("PERSISTING -1");
            Logger.getLogger(AppUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void persist(AppChannel appChannel) {
        Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Attempting to persist " + appChannel);
        try {
            //Get the current JTA transaction handler and begin a new transaction
            UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            
            // Persit our AppUser object (send it to the database)
            em.merge(appChannel);
            
            // Commit our transaction
            transaction.commit();
            Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Persist successful!");
        } catch (Exception ex) {
            Logger.getLogger(AppUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
