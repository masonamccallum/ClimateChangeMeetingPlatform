package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONObject;

/**
 * This AppUser entity class was generated from a database.
 * 
 * @author Johnny
 */

@Entity
@Table(name = "appusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUser.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUser.findByUserId", query = "SELECT a FROM AppUser a WHERE a.userId = :userId"),
    @NamedQuery(name = "AppUser.findByEmail", query = "SELECT a FROM AppUser a WHERE a.email = :email"),
    @NamedQuery(name = "AppUser.findByUsername", query = "SELECT a FROM AppUser a WHERE a.username = :username"),
    @NamedQuery(name = "AppUser.findByOwnedChannelIds", query = "SELECT a FROM AppUser a WHERE a.ownedChannelIds = :ownedChannelIds"),
    @NamedQuery(name = "AppUser.findByParticipatingChannelIds", query = "SELECT a FROM AppUser a WHERE a.participatingChannelIds = :participatingChannelIds")})
public class AppUser implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private Integer userId;
    
// @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    
    @Size(max = 255)
    @Column(name = "username")
    private String username;
    
    @Column(name = "owned_channel_ids")
    @Convert(converter = StringToIntegerListConverter.class)
    private List<Integer> ownedChannelIds;
    
    @Column(name = "participating_channel_ids")
    @Convert(converter = StringToIntegerListConverter.class)
    private List<Integer> participatingChannelIds;
    
    @Size(max = 2147483647)
    @Column(name = "password")
    private String password;

    public AppUser() {
    }

    public AppUser(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getOwnedChannelIds() {
        return ownedChannelIds;
    }

    public void setOwnedChannelIds(List<Integer> ownedChannelIds) {
        this.ownedChannelIds = ownedChannelIds;
    }

    public List<Integer> getParticipatingChannelIds() {
        return participatingChannelIds;
    }

    public void setParticipatingChannelIds(List<Integer> participatingChannelIds) {
        this.participatingChannelIds = participatingChannelIds;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AppUser[ \n"
                + "\tuserId=" + userId + ",\n"
                + "\tusername=" + username + " ]";
    }

      
    /**
    *  Returns a simple JSON representation of this AppUser.
    *  This JSON only contains the username and email.
    *
    *  @return  a JSONObject
    */
    public JSONObject toSimpleJson() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("username", this.username);
        jsonObj.put("email", this.email);
        
        return jsonObj;
    }
}
