/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.api.Models.Role;
import java.util.List;

/**
 *
 * @author Mario HP
 */
public interface IRoleService {
    
      List<Role> getAllRoles();
    Role getRoleById(int roleId);
    boolean updateRole(Role role);
 
}
