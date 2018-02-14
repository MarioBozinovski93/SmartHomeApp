/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Controllers;

import com.diplomska.api.Models.Device;
import com.diplomska.api.Models.User;
import com.diplomska.api.Services.IDeviceService;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mario HP
 */
@CrossOrigin
@RestController
@RequestMapping("/device")
public class DeviceController {
    
    @Autowired
    private IDeviceService deviceService;
    
    @RequestMapping("/getall")
    public List<Device> getAllDevices() {
        
        return deviceService.getAllDevices(); // userService.getAllUsers();
        
    }
   @RequestMapping(value = "/{slot}", method = RequestMethod.GET)
    public Device getDeviceBySlot(@PathVariable int slot) {
        return deviceService.getDeviceBySlot(slot);
    }
       @RequestMapping(method = RequestMethod.POST, value = "/add", consumes = "application/json")
    public void addDevice(@RequestBody Device device) {
        deviceService.addDevice(device);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", consumes = "application/json")
    public void updateDevice(@RequestBody Device device) {
        deviceService.updateDevice(device);
    }
    
     public static GpioPinDigitalOutput pin;
    
       @RequestMapping(method = RequestMethod.PUT, value = "/updateON", consumes = "application/json")
    public void updateDeviceON(@RequestBody Device device) {
          if(pin==null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,"My LED", PinState.HIGH);
        }
       
        pin.high();    
        pin.toggle();
        deviceService.updateDevice(device);
    }
    
       @RequestMapping(method = RequestMethod.PUT, value = "/updateOFF", consumes = "application/json")
    public void updateDeviceOFF(@RequestBody Device device) {
         if(pin==null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,"My LED", PinState.LOW);
        }
        
        pin.low();
       pin.toggle();
        deviceService.updateDevice(device);
    }
    
    /*Works with Postman*/
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{userId}")
    public void deleteDevice(@PathVariable int deviceId) {
        deviceService.deleteDevice(deviceId);
    }
    
}
