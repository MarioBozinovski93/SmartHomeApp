package com.diplomska.api.DAO;

import com.diplomska.api.Models.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mario HP
 */
@Transactional
@Repository
public class UserDAO implements IUserDAO{
    
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
          String hql = "FROM User as user1 ORDER BY user1.userId";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId); 
    }

    @Override
    public void addUser(User user) {
         entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
         entityManager.merge(user);
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(getUserById(userId));
    }

    @Override
    public boolean userExists(String userName) {
        String hql = "FROM User as user1 WHERE user1.userName = ?";
        int count = entityManager.createQuery(hql).setParameter(1, userName)
                .getResultList().size();
        return count > 0 ? true : false;
    }
    
}
