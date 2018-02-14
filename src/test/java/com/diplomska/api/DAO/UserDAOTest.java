/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.DAO;

import com.diplomska.SpringBoot;
import com.diplomska.api.Models.Role;
import com.diplomska.api.Models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
public class UserDAOTest {
    
    @Autowired
    IUserDAO userDAO;
    
    @Autowired
    IUserRepository iuserrep;
    
    public UserDAOTest() {
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
     * Test of getAllUsers method, of class UserDAO.
     */
    @Test
    public void testGetAllUsers() throws JsonProcessingException {
      List<User> u;

        u = userDAO.getAllUsers();
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(u);
        
        
        System.out.println(json);
        assertEquals(2, u.size());
    }

    /**
     * Test of getUserById method, of class UserDAO.
     */
    @Test
    public void testGetUserById() {
        User u = userDAO.getUserById(4);
        
        assertEquals("Krasimir", u.getUserName());
    }

    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
       User u = new User();
       u.setUserName("mario");
       u.setPassword("321654");
       
       Role role = iuserrep.getRoleByCat(0);
       u.setRole(role);
       
       userDAO.addUser(u);
       
        assertEquals(1, u.hashCode());
    }

    /**
     * Test of updateUser method, of class UserDAO.
     */
    @Test
    public void testUpdateUser() {
      User u;
      
      u = userDAO.getUserById(4);
      u.setEmail("krasemk@t-home.com");
      u.setLog(true);
      u.setUserName("Krase");
      u.setPassword("321");
      Role role = iuserrep.getRoleByCat(1);
      u.setRole(role);
      
      userDAO.updateUser(u);
    }

    /**
     * Test of deleteUser method, of class UserDAO.
     */
    @Test
    public void testDeleteUser() {
       userDAO.deleteUser(4);
    }

    /**
     * Test of userExists method, of class UserDAO.
     */
    @Test
    public void testUserExists() {
       String username = "Krasimir";
       
        assertEquals(true, userDAO.userExists(username));
    }
    
}
