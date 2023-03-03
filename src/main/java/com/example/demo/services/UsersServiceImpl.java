package com.example.demo.services;

import com.example.demo.dao.UsersDao;
import com.example.demo.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Transactional
    @Override
    public void addUser(Users users) {
        usersDao.addUser(users);
    }
    @Override
    @Transactional
    public void removeUser(int id) {
        usersDao.removeUser(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public Users findOne(int id) {
        return usersDao.findOne(id);
    }

    @Override
    @Transactional
    public void update(int id, Users users) {
        usersDao.update(id, users);
    }

}
