package com.example.demo.services;
import com.example.demo.models.Users;
import java.util.List;


public interface UsersService {
    void addUser(Users users);
    void removeUser(int id);
    List<Users> getAllUsers();

    Users findOne(int id);

    void update(int id, Users users);
}
