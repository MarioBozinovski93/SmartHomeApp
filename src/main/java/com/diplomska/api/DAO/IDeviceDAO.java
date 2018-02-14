/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario HP
 */

package com.diplomska.api.DAO;

import com.diplomska.api.Models.Device;
import java.util.List;

public interface IDeviceDAO {
    
    
    
    
   List<Device> getAllDevices();
   Device getDeviceById(int deviceId);
    
    void addDevice(Device device);
    void updateDevice(Device device);
    void deleteDevice(int deviceId);
    boolean deviceExists(String deviceName);
    
}
