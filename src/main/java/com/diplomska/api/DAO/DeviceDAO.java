package com.diplomska.api.DAO;
import com.diplomska.api.Models.Device;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario HP
 */

@Transactional
@Repository
public class DeviceDAO implements IDeviceDAO{
    
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Device> getAllDevices() {
        String hql = "FROM Device as device1 ORDER BY device1.DeviceId";
        return entityManager.createQuery(hql).getResultList();    }

    @Override
    public Device getDeviceById(int DeviceId) {
         return entityManager.find(Device.class, DeviceId); 
    }

    @Override
    public void addDevice(Device device) {
        entityManager.persist(device);
    }

    @Override
    public void updateDevice(Device device) {
        entityManager.merge(device); 
    }

    @Override
    public void deleteDevice(int deviceId) {
         entityManager.remove(getDeviceById(deviceId));  
    
    }

    @Override
    public boolean deviceExists(String deviceName) {
 String hql = "FROM Device as device1 WHERE device1.DeviceName = ?";
        int count = entityManager.createQuery(hql).setParameter(1, deviceName)
                .getResultList().size();
        return count > 0 ? true : false;
    }
    
}
