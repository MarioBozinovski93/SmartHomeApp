/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.SpringBoot;
import com.diplomska.api.DAO.IUserRepository;
import com.diplomska.api.Models.Role;
import com.diplomska.api.Models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class UserServiceTest {
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IUserRepository iuserrep;
    
    public UserServiceTest() {
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
     * Test of getAllUsers method, of class UserService.
     */
    @Test
    public void testGetAllUsers() throws JsonProcessingException {
       List<User> u =  userService.getAllUsers();
        ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writeValueAsString(u);
        System.out.println(json);
        
        assertEquals(1, u.size());
    }

    /**
     * Test of getUserById method, of class UserService.
     */
    @Test
    public void testGetUserById() throws JsonProcessingException {
           User u = userService.getUserById(2);
       
       ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writeValueAsString(u);
        System.out.println(json);
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() {
         User u = new User();
      u.setUserName("Mario22");
      u.setPassword("aaa");
      
      Role role = new Role();
       role = iuserrep.getRoleByCat(1);
      u.setRole(role);
      
      if (userService.userExists(u.getUserName())){
          System.out.println("NE MOZE DA SE DODADE");
      }
      else {
          userService.addUser(u);
                    System.out.println("USPESNO DODAVANJE");

      }
        assertEquals(2, userService.getAllUsers().size() );
    }

    /**
     * Test of updateUser method, of class UserService.
     */
    @Test
    public void testUpdateUser() {
           User u = new User();
       u = userService.getUserById(1);
       u.setEmail("novmail");
       
//       if(userSERVICE.userExists(u.getUserName())){
//           System.out.println("Postoi USER so takov username");
//       }
//       else{
           userService.updateUser(u);
//       }
    }

    /**
     * Test of deleteUser method, of class UserService.
     */
    @Test
    public void testDeleteUser() {
     userService.deleteUser(2);
    }

    /**
     * Test of userExists method, of class UserService.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        String userName = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.userExists(userName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
