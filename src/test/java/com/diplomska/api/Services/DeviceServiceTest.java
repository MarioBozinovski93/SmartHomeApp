/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.SpringBoot;
import com.diplomska.api.Models.Device;
import com.diplomska.api.Models.User;
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
public class DeviceServiceTest {
    
    @Autowired
    private IDeviceService deviceService;
    
    @Autowired
    private IUserService userService;
    
    public DeviceServiceTest() {
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
     * Test of getAllDevices method, of class DeviceService.
     */
    @Test
    public void testGetAllDevices() {
        List<Device> d = deviceService.getAllDevices();
        
        assertEquals(d.size(), 3);
    }

    /**
     * Test of getDeviceById method, of class DeviceService.
     */
    @Test
    public void testGetDeviceById() {
        System.out.println("getDeviceById");
        int deviceId = 0;
        DeviceService instance = new DeviceService();
        Device expResult = null;
        Device result = instance.getDeviceById(deviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDevice method, of class DeviceService.
     */
    @Test
    public void testAddDevice() {
        System.out.println("addDevice");
        Device device = null;
        DeviceService instance = new DeviceService();
        boolean expResult = false;
        boolean result = instance.addDevice(device);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDevice method, of class DeviceService.
     */
    @Test
    public void testUpdateDevice() {
      Device d = deviceService.getDeviceById(2);
      User u = userService.getUserById(1);
      d.setUser(u);
      d.setStatus(true);
      
      deviceService.updateDevice(d);
      
    }

    /**
     * Test of deleteDevice method, of class DeviceService.
     */
    @Test
    public void testDeleteDevice() {
        System.out.println("deleteDevice");
        int deviceId = 0;
        DeviceService instance = new DeviceService();
        boolean expResult = false;
        boolean result = instance.deleteDevice(deviceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deviceExists method, of class DeviceService.
     */
    @Test
    public void testDeviceExists() {
        System.out.println("deviceExists");
        String deviceName = "";
        DeviceService instance = new DeviceService();
        boolean expResult = false;
        boolean result = instance.deviceExists(deviceName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
