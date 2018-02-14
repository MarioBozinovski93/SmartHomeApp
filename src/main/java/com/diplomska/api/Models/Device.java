/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mario HP
 */
@Entity
public class Device {
      private static final long serialVersionUID = 1L;
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DeviceId;
    
    private String DeviceName;
    
    private boolean Status;
    
    private int RelaySlotNumber;
    
    private String Description;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID")
    @JsonIgnoreProperties("device")
    private User user;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.DeviceId;
        hash = 97 * hash + Objects.hashCode(this.DeviceName);
        hash = 97 * hash + (this.Status ? 1 : 0);
        hash = 97 * hash + this.RelaySlotNumber;
        hash = 97 * hash + Objects.hashCode(this.Description);
        hash = 97 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Device other = (Device) obj;
        if (this.DeviceId != other.DeviceId) {
            return false;
        }
        if (this.Status != other.Status) {
            return false;
        }
        if (this.RelaySlotNumber != other.RelaySlotNumber) {
            return false;
        }
        if (!Objects.equals(this.DeviceName, other.DeviceName)) {
            return false;
        }
        if (!Objects.equals(this.Description, other.Description)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    public int getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(int DeviceId) {
        this.DeviceId = DeviceId;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public int getRelaySlotNumber() {
        return RelaySlotNumber;
    }

    public void setRelaySlotNumber(int RelaySlotNumber) {
        this.RelaySlotNumber = RelaySlotNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
