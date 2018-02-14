/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario HP
 */

package com.diplomska.api.DAO;

import com.diplomska.api.Models.Role;
import java.util.List;


public interface IRoleDAO {
    
    
    List<Role> getAllRoles();
    Role getRoleById(int roleId);
    void updateRole(Role role);
    boolean RoleExists(int category);
    
}
