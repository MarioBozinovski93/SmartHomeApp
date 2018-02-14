/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.api.DAO.IRoleDAO;
import com.diplomska.api.Models.Role;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario HP
 */
@Service
public class RoleService implements IRoleService{
    @Autowired
    IRoleDAO roleDAO;

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public Role getRoleById(int roleId) {
      return roleDAO.getRoleById(roleId);
    }

   

    @Override
    public synchronized boolean updateRole(Role role) {
        if(roleDAO.RoleExists(role.getCategory())){
            roleDAO.updateRole(role);
            return true;
        } else{
            return false;
        }
        }

    

  
  
  
}
