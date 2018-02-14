/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.DAO;

import com.diplomska.SpringBoot;
import com.diplomska.api.Models.Role;
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
public class RoleDAOTest {
    
    @Autowired
    IRoleDAO roleDAO;
    public RoleDAOTest() {
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
     * Test of getAllRoles method, of class RoleDAO.
     */
    @Test
    public void testGetAllRoles() {
        List<Role> r = roleDAO.getAllRoles();
        
        assertEquals(3,r.size());
    }

    /**
     * Test of getRoleById method, of class RoleDAO.
     */
    @Test
    public void testGetRoleById() {
        System.out.println("getRoleById");
        int roleId = 0;
        RoleDAO instance = new RoleDAO();
        Role expResult = null;
        Role result = instance.getRoleById(roleId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRole method, of class RoleDAO.
     */
    @Test
    public void testUpdateRole() {
        System.out.println("updateRole");
        Role role = null;
        RoleDAO instance = new RoleDAO();
        instance.updateRole(role);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RoleExists method, of class RoleDAO.
     */
    @Test
    public void testRoleExists() {
        System.out.println("RoleExists");
        int category = 0;
        RoleDAO instance = new RoleDAO();
        boolean expResult = false;
        boolean result = instance.RoleExists(category);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
