/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.api.DAO.IDeviceDAO;
import com.diplomska.api.DAO.IUserRepository;
import com.diplomska.api.Models.Device;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario HP
 */
@Service
public class DeviceService implements IDeviceService{
    
    @Autowired
    private IDeviceDAO deviceDAO;
    
    @Autowired
    private IUserRepository iuserrep;

    @Override
    public List<Device> getAllDevices() {
       return deviceDAO.getAllDevices();
    }

    @Override
    public Device getDeviceById(int deviceId) {
        return deviceDAO.getDeviceById(deviceId);
    }

    @Override
    public synchronized boolean addDevice(Device device) {
       if(deviceDAO.deviceExists(device.getDeviceName())){
           return false;
       }else{
           deviceDAO.addDevice(device);
           return true;
       }
    }

    @Override
    public synchronized boolean updateDevice(Device device) {
       
        deviceDAO.updateDevice(device);
       return true;
       
    }

    @Override
    public synchronized boolean deleteDevice(int deviceId) {
        Device device = deviceDAO.getDeviceById(deviceId);
        if(deviceDAO.deviceExists(device.getDeviceName())){
           deviceDAO.deleteDevice(deviceId);
           return true;
       }else{
           return false;
       }
    }

    @Override
    public boolean deviceExists(String deviceName) {
       return deviceDAO.deviceExists(deviceName);
    }

    @Override
    public Device getDeviceBySlot(int slot) {
        return iuserrep.getDeviceBySlot(slot);
    }

    
    
}
