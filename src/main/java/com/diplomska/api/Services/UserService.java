/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diplomska.api.Services;

import com.diplomska.api.DAO.IUserDAO;
import com.diplomska.api.Models.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mario HP
 */
@Service
public class UserService implements IUserService{
    
    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
     return   userDAO.getAllUsers();
    
    }

    @Override
    public User getUserById(int userId) {
        User user1 = userDAO.getUserById(userId);
        return user1;
    }

    @Override
    public synchronized boolean addUser(User user) {
        if(userDAO.userExists(user.getUserName())){
            return false;
        }else{
            userDAO.addUser(user);
            return true;
        }
    }

    @Override
    public synchronized boolean updateUser(User user) {
          if(userDAO.userExists(user.getUserName())){
              userDAO.updateUser(user);
            return true;
        }else{
         return false;
        }
    }

    @Override
    public synchronized boolean deleteUser(int userId) {
        User user = userDAO.getUserById(userId);
   if(userDAO.userExists(user.getUserName())){
              userDAO.deleteUser(userId);
            return true;
        }else{
         return false;
        }    }

    @Override
    public boolean userExists(String userName) {
       return     userDAO.userExists(userName);
        }

    

    
}
