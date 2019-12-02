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
 * The AppUserManager handles user queries and transactions to and from the database.
 * 
 * @author Johnny
 */
public class AppUserManager {
   
    protected EntityManager em;

    public AppUserManager(EntityManager em) {
        this.em = em;
    }
    
    protected List<AppUser> getAllAppUsers() {
        return em.createNamedQuery("AppUser.findAll").getResultList();
    }
    
    protected String getAllAppUsersAsJSONString() {
        List<AppUser> appUsers = em.createNamedQuery("AppUser.findAll").getResultList();
        
        ListIterator<AppUser> it = appUsers.listIterator();
        List<JSONObject> jsonStrings = new ArrayList<>();
        for (AppUser user : appUsers) {
            jsonStrings.add(user.toSimpleJson());
        }
        
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("users", jsonStrings);
        return jsonObj.toString();
    }
    
    protected AppUser getAppUserByUserId(Integer id) {
        return (AppUser)em.createNamedQuery("AppUser.findByUserId")
                .setParameter("userId", id)
                .getResultList().get(0);
    }
    
    protected AppUser getAppUserByUsername(String username) {
        System.out.println(username);
        return (AppUser)em.createNamedQuery("AppUser.findByUsername")
                .setParameter("username", username)
                .getResultList().get(0);
    }
    
    protected void update(AppUser appUser) {
        Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Attempting to update " + appUser);
        try {
            //Get the current JTA transaction handler and begin a new transaction
            UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            
            // Persit our AppUser object (send it to the database)
            em.merge(appUser);
            
            // Commit our transaction
            transaction.commit();
            Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Update successeful!");
        } catch (Exception ex) {
            System.out.println("PERSISTING -1");
            Logger.getLogger(AppUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void persist(AppUser appUser) {
        Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Attempting to persist " + appUser);
        try {
            //Get the current JTA transaction handler and begin a new transaction
            UserTransaction transaction = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            
            // Persit our AppUser object (send it to the database)
            em.persist(appUser);
            
            // Commit our transaction
            transaction.commit();
            Logger.getLogger(AppUser.class.getName()).log(Level.FINE, null, "Persist successful!");
        } catch (Exception ex) {
            Logger.getLogger(AppUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
