/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Controllers;

import com.diplomska.api.Models.Role;
import com.diplomska.api.Services.IRoleService;
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
@RequestMapping("/role")
public class RoleController {
    
      @Autowired
    private IRoleService roleService;
    
    @RequestMapping("/getall")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }
    
    @RequestMapping("/get/{roleId}")
    public Role getRoleById(@PathVariable int roleId) {
        return roleService.getRoleById(roleId);
    }
    
    
    
    @RequestMapping(method = RequestMethod.PUT, value = "/update/{roleId}")
    public void updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
    }
    
    
}
