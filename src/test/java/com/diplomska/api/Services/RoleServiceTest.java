/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.SpringBoot;
import com.diplomska.api.Models.Role;
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
public class RoleServiceTest {
    
    @Autowired
    IRoleService roleService;
    
    public RoleServiceTest() {
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
     * Test of getAllRoles method, of class RoleService.
     */
    @Test
    public void testGetAllRoles() throws JsonProcessingException {
      List<Role> r =  roleService.getAllRoles();
        ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writeValueAsString(r);
        System.out.println(json);
        assertEquals(3, roleService.getAllRoles().size());
    }

    /**
     * Test of getRoleById method, of class RoleService.
     */
    @Test
    public void testGetRoleById() throws JsonProcessingException {
       Role r = new Role();
      r = roleService.getRoleById(1);
      ObjectMapper mapper = new ObjectMapper();
        
        String json = mapper.writeValueAsString(r);
        System.out.println(json);
        assertEquals(r, roleService.getRoleById(1));
    }

    /**
     * Test of updateRole method, of class RoleService.
     */
    @Test
    public void testUpdateRole() {
       Role r = new Role();
        r = roleService.getRoleById(1);
        r.setCategory(0);
        roleService.updateRole(r);
    }
    
}
