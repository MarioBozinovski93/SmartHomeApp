package com.diplomska.api.DAO;
import com.diplomska.api.Models.Role;
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
public class RoleDAO implements  IRoleDAO{

    @PersistenceContext
    private EntityManager entityManager;

    
    @Override
    public List<Role> getAllRoles() {
        String hql = "FROM Role as role1 ORDER BY role1.roleId";
        return (List<Role>)entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Role getRoleById(int roleId) {
         return entityManager.find(Role.class, roleId);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public boolean RoleExists(int category) {
        String hql = "FROM Role as role1 WHERE role1.category = ?";
        int count = entityManager.createQuery(hql).setParameter(1, category)
                .getResultList().size();
        return count > 0 ? true : false;  
    }
    
}
