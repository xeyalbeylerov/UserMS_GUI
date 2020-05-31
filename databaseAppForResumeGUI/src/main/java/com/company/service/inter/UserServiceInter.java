package com.company.service.inter;

import com.company.entity.User;

import java.util.List;

public interface UserServiceInter {
    List<User> getAll();
    User getById(int userId);
    User getByEmail(String email);
    boolean addUser(User u);
    User checkUserPassword(User u,String password);
    boolean updateUser(User u);
    boolean updateUserFilter(User u);
    boolean removeUser(int i);
    List<User> searchByNameAndSurname(String name,String surname);
}
