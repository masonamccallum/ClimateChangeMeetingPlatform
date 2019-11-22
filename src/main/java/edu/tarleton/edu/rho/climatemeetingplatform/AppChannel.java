/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tarleton.edu.rho.climatemeetingplatform;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.JSONObject;

/**
 *
 * @author Johnny
 */
@Entity
@Table(name = "appchannels")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AppChannel.findAll", query = "SELECT a FROM AppChannel a"),
    @NamedQuery(name = "AppChannel.findByChannelId", query = "SELECT a FROM AppChannel a WHERE a.channelId = :channelId"),
    @NamedQuery(name = "AppChannel.findByChannelName", query = "SELECT a FROM AppChannel a WHERE a.channelName = :channelName"),
    @NamedQuery(name = "AppChannel.findByChannelDesc", query = "SELECT a FROM AppChannel a WHERE a.channelDesc = :channelDesc"),
    @NamedQuery(name = "AppChannel.findByOwnerId", query = "SELECT a FROM AppChannel a WHERE a.ownerId = :ownerId"),
    @NamedQuery(name = "AppChannel.findByAdminIds", query = "SELECT a FROM AppChannel a WHERE a.adminIds = :adminIds"),
    @NamedQuery(name = "AppChannel.findByParticipantIds", query = "SELECT a FROM AppChannel a WHERE a.participantIds = :participantIds")})
public class AppChannel implements Serializable {

    @Transient
    private static Integer NextChannelId = 7;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "channel_id")
    private Integer channelId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "channel_name")
    private String channelName;
        
    @Size(max = 2147483647)
    @Column(name = "channel_desc")
    private String channelDesc;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "owner_id")
    private Integer ownerId;
    
    @Size(max = 2147483647)
    @Column(name = "admin_ids")
    @Convert(converter = StringToIntegerListConverter.class)
    private List<Integer> adminIds;
    
    @Size(max = 2147483647)
    @Column(name = "participant_ids")
    @Convert(converter = StringToIntegerListConverter.class)
    private List<Integer> participantIds;

    public AppChannel() {
        this.channelId = this.getNewChannelId();
    }

    public AppChannel(Integer channelId) {
        this.channelId = channelId;
    }

    public AppChannel(Integer channelId, String channelName, int ownerId) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.ownerId = ownerId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public List<Integer> getAdminIds() {
        return adminIds;
    }

    public void setAdminIds(List<Integer> adminIds) {
        this.adminIds = adminIds;
    }

    public List<Integer> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<Integer> participantIds) {
        this.participantIds = participantIds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (channelId != null ? channelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppChannel)) {
            return false;
        }
        AppChannel other = (AppChannel) object;
        if ((this.channelId == null && other.channelId != null) || (this.channelId != null && !this.channelId.equals(other.channelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.tarleton.edu.rho.climatemeetingplatform.AppChannel[ channelId=" + channelId + " ]";
    }
    
    public JSONObject toInfoJson() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("channel_id", this.channelId);
        jsonObj.put("channel_name", this.channelName);
        jsonObj.put("channel_desc", this.channelDesc);
        jsonObj.put("owener_id", this.ownerId);
        
        return jsonObj;
    }
    
    public static Integer getNewChannelId() {
        Integer temp = NextChannelId;
        NextChannelId += 1;
        return temp;
    }
}
