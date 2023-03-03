package com.example.demo.dao;

import com.example.demo.models.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UsersDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(Users users) {
        entityManager.persist(users);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(findOne(id));
    }

    @Override
    public List<Users> getAllUsers() {
        return entityManager.createQuery("from Users", Users.class).getResultList();
    }

    @Override
    public Users findOne(int id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    public void update(int id, Users users) {
        Users oldUsers = entityManager.find(Users.class, id);
        oldUsers.setName(users.getName());
        oldUsers.setAge(users.getAge());
    }
}