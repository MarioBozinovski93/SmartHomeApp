/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.api.Models.Device;
import java.util.List;

/**
 *
 * @author Mario HP
 */
public interface IDeviceService {
    
        
   List<Device> getAllDevices();
   Device getDeviceById(int deviceId);
    Device getDeviceBySlot(int slot);
    boolean addDevice(Device device);
    boolean updateDevice(Device device);
    boolean deleteDevice(int deviceId);
    boolean deviceExists(String deviceName);
    
}
