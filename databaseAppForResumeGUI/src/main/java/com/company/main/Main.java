/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.inter.EmployementHistorylDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

/**
 * @author xeyal
 */
public class Main {


    public static void main(String[] args) throws Exception {
        EmployementHistorylDaoInter userdao2 = Context.instanceEmployementHistoryDao();
        System.out.println(userdao2.getAllEmployementHistoryByUserId(4));
        UserDaoInter userDao = Context.instanceUserDao();
        System.out.println(userDao.getAll());

        String email = "xeyalbeylerov@mail.ru";
        String password = "123123";
//        User u = new User(15, "Xeyal", "Beylerov", password, email);
//        userDao.addUser(u);

        User u2 = loginUser(email, password);
        System.out.println("Logged user= "+u2);

//        for(int i=0;i<10;i++){
//            String pass="asasd"+i;
//            System.out.println("Native pass: "+pass);
//            String passHash=getHash2(pass);
//            System.out.println("Pass:"+passHash);
//            System.out.println("verify "+verifyHash2(pass,passHash));
//        }
    }

    public static User loginUser(String email, String password) {
        UserDaoInter userDao = Context.instanceUserDao();
        User u = userDao.getByEmail(email);
        User u2=userDao.checkUserPassword(u,password);
        return u2;
    }


//


}
