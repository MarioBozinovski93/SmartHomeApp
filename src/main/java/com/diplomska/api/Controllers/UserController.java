/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Controllers;

import com.diplomska.api.DAO.IUserDAO;
import com.diplomska.api.Models.User;
import com.diplomska.api.Services.IUserService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Mario HP
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IUserDAO userDAO;
    
    @RequestMapping("/getall")
    public List<User> getAllUsers() {
        
        return userService.getAllUsers(); // userService.getAllUsers();
        
    }
    
    
    public static GpioPinDigitalOutput pin;
    
    @RequestMapping("/turnON")
    public String lightON() {
        if(pin==null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,"My LED", PinState.HIGH);
        }
        
        pin.high();
        pin.toggle();
        return "Response from light ON!!";
    }
    
       @RequestMapping("/turnOFF")
    public String lightOFF() {
        if(pin==null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,"My LED", PinState.LOW);
        }
        
        pin.low();
        pin.toggle();
        return "Response from light!!";
    }
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/add", consumes = "application/json")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update", consumes = "application/json")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    /*Works with Postman*/
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}
