/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.dao.impl.*;
import com.company.dao.inter.*;
import com.company.service.impl.UserServiceImpl;
import com.company.service.inter.UserServiceInter;

/**
 * @author xeyal
 */
public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImpl();
    }

    public static UserSkillDaoInter instanceUserSkillDao() {
        return new UserSkillDaoImpl();
    }

    public static EmployementHistorylDaoInter instanceEmployementHistoryDao() {
        return new EmployementHistorylDaoImpl();
    }

    public static CountryDaoInter instanceCountryDao() {
        return new CountryDaoImpl();
    }

    public static SkillDaoInter instanceSkillDao() {
        return new SkillDaoImpl();
    }

    public static UserServiceInter instanceUserService() {
        return new UserServiceImpl();
    }
}
