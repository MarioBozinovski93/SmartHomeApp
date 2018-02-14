/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.DAO;

import com.diplomska.SpringBoot;
import com.diplomska.api.Models.Device;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Mario HP
 */
@SpringBootTest(classes = SpringBoot.class)
@RunWith(SpringRunner.class)
public class DeviceDAOTest {
    
    @Autowired
    IDeviceDAO deviceDAO;
    
    public DeviceDAOTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllDevices method, of class DeviceDAO.
     */
    @Test
    public void testGetAllDevices() {
       List<Device> d = deviceDAO.getAllDevices();
       
        assertEquals(d.size(), 3);
    }

    /**
     * Test of getDeviceById method, of class DeviceDAO.
     */
    @Test
    public void testGetDeviceById() {
        System.out.println("getDeviceById");
        int DeviceId = 0;
        DeviceDAO instance = new DeviceDAO();
        Device expResult = null;
        Device result = instance.getDeviceById(DeviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDevice method, of class DeviceDAO.
     */
    @Test
    public void testAddDevice() {
        Device d = new Device();
        
        d.setDeviceName("Led Light");
        d.setDescription("Vo dvor");
        d.setRelaySlotNumber(4);
        d.setStatus(false);
        
        deviceDAO.addDevice(d);
      
    }

    /**
     * Test of updateDevice method, of class DeviceDAO.
     */
    @Test
    public void testUpdateDevice() {
        Device d = deviceDAO.getDeviceById(3);
        
        d.setDeviceName("Neonka2");
        d.setDescription("Vo dnevna2");
        d.setRelaySlotNumber(7);
        d.setStatus(false);
        
        deviceDAO.updateDevice(d);
    }

    /**
     * Test of deleteDevice method, of class DeviceDAO.
     */
    @Test
    public void testDeleteDevice() {
        System.out.println("deleteDevice");
        int deviceId = 0;
        DeviceDAO instance = new DeviceDAO();
        instance.deleteDevice(deviceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deviceExists method, of class DeviceDAO.
     */
    @Test
    public void testDeviceExists() {
     deviceDAO.deviceExists("Neonka");
    }
    
}
