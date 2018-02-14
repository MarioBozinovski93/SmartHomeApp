/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.api.Models.User;
import java.util.List;

/**
 *
 * @author Mario HP
 */
public interface IUserService {
    
    List<User> getAllUsers();
    User getUserById(int userId);
    
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int userId);
    boolean userExists(String userName);
    
}
