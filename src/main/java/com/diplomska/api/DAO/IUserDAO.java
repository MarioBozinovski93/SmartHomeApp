package com.diplomska.api.DAO;
        
import com.diplomska.api.Models.User;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario HP
 */
public interface IUserDAO {
    
    
   List<User> getAllUsers();
   User getUserById(int userId);
    
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    boolean userExists(String userName);
    
}
