/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author xeyal
 */
public abstract class AbstractDAO{
    //metod məlumatlardan connection obyekti düzəldib return edir
    public Connection connect() throws SQLException{
//        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";
        String password = "123123";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
