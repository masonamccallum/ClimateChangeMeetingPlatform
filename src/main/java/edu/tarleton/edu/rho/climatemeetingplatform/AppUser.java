package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Johnny
 */
@Entity
@Table(name = "appusers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppUsers.findAll", query = "SELECT a FROM AppUser a"),
    @NamedQuery(name = "AppUsers.findByUserid", query = "SELECT a FROM AppUser a WHERE a.userid = :userid"),
    @NamedQuery(name = "AppUsers.findByUsername", query = "SELECT a FROM AppUser a WHERE a.username = :username"),
    @NamedQuery(name = "AppUsers.findByEmail", query = "SELECT a FROM AppUser a WHERE a.email = :email")})
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "email")
    private String email;

    public AppUser() {
    }

    public AppUser(Integer userid) {
        this.userid = userid;
    }

    public AppUser(Integer userid, String username) {
        this.userid = userid;
        this.username = username;
    }
    
    
    
    public AppUser(Integer userid, String username, String email) {
        this.userid = userid;
        this.username = username;
        this.email = email;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tarleton.edu.rho.climatemeetingplatform.AppUser[ userid=" + userid + " ]";
    }
    
}
