package com.company.service.impl;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import com.company.main.Context;
import com.company.service.inter.UserServiceInter;

import java.util.List;

public class UserServiceImpl implements UserServiceInter {
    UserDaoInter userDao = Context.instanceUserDao();

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    @Override
    public User getByEmail(String email) {
       return userDao.getByEmail(email);
    }

    @Override
    public boolean addUser(User u) {
        return userDao.addUser(u);
    }

    @Override
    public User checkUserPassword(User user, String password) {
        if (user==null||password==null)return null;
        return userDao.checkUserPassword(user,password);
    }

    @Override
    public boolean updateUser(User u) {
        return userDao.updateUser(u);
    }

    @Override
    public boolean updateUserFilter(User u) {
        return userDao.updateUserNameAndSurnameAndPassword(u);
    }

    @Override
    public boolean removeUser(int i) {
        return userDao.removeUser(i);
    }

    @Override
    public List<User> searchByNameAndSurname(String name, String surname) {
        if (name == null) name = "";
        if (surname == null) surname = "";
        return userDao.searchByNameAndSurname(name,surname);
    }
}
