/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.User;

import java.util.List;

/**
 * @author xeyal
 */
public interface UserDaoInter {
    List<User> getAll();
    User getById(int userId);
    User getByEmail(String email);
    boolean addUser(User u);
    User checkUserPassword(User u,String password);
    boolean updateUser(User u);
    boolean updateUserNameAndSurnameAndPassword(User u);
    boolean removeUser(int i);
    List<User> searchByNameAndSurname(String name,String surname);
}
