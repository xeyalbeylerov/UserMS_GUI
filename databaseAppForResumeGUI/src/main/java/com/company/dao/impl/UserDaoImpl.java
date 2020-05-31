/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.Country;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xeyal
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    //bu method ResultSet dolduranda istifadə olunacaq.Resulset qəbul edib User qaytaracaq.
    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String password = rs.getString("password");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String address = rs.getString("address");
        String profileDesc = rs.getString("profile_description");
        int nationalityId = rs.getInt("nationality_id");
        int birthplaceId = rs.getInt("birthplace_id");
        String nationalityStr = rs.getString("nationality");
        String birthplaceStr = rs.getString("birthplace");
        Date birthdate = rs.getDate("birthdate");
        boolean isAdmin = rs.getBoolean("is_admin");
        Country nationality = new Country(nationalityId, null, nationalityStr);
        Country birthplace = new Country(birthplaceId, birthplaceStr, null);
        return (new User(id, name, surname, password, email, address, profileDesc, phone, birthdate, nationality, birthplace, isAdmin));
    }


    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	n.`nationality`,"
                    + "	c.`name` AS birthplace "
                    + "FROM"
                    + "	USER u"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean removeUser(int i
    ) {
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            stmt.execute("delete from user where id =" + i);

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("update user set name=?,surname=?,phone=?,email=?,profile_description=?,birthdate=?,address=?,birthplace_id=?,password=? where id =?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setDate(6, u.getBirthDate());
            stmt.setString(7, u.getAddress());
            stmt.setInt(8, u.getBirthPlace().getId());
            stmt.setString(9, getHash(u.getPassword()));
            stmt.setInt(10, u.getId());
            stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
        return true;
    }

    @Override
    public boolean updateUserNameAndSurnameAndPassword(User u) {
        try (Connection conn = connect()) {
            StringBuilder sb = new StringBuilder("update user set name=name ");
            if (u.getName() != null && !u.getName().isEmpty()) {
                sb.append(",name='" + u.getName() + "' ");
            }
            if (u.getSurname() != null && !u.getSurname().isEmpty()) {
                sb.append(",surname='" + u.getSurname() + "' ");
            }
            if (u.getPhone() != null && !u.getPassword().isEmpty()) {

                sb.append(",password='" + getHash(u.getPassword()) + "' ");
            }
            sb.append("where id=" + u.getId());
            PreparedStatement stmt = conn.prepareStatement(sb.toString());
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
        return true;
    }

    @Override
    public User getById(int userId
    ) {
        User result = null;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	n.`nationality`,"
                    + "	c.`name` AS birthplace "
                    + "FROM"
                    + "	USER u"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id where u.id=" + userId);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public User getByEmail(String email) {
        User result = null;
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	n.`nationality`,"
                    + "	c.`name` AS birthplace "
                    + "FROM"
                    + "	USER u"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id where u.email='" + email + "'");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                result = getUser(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public List<User> searchByNameAndSurname(String name, String surname) {
        List<User> result = new ArrayList<>();
        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT"
                    + "	u.*,"
                    + "	n.`nationality`,"
                    + "	c.`name` AS birthplace "
                    + "FROM"
                    + "	USER u"
                    + "	LEFT JOIN country n ON u.nationality_id = n.id"
                    + "	LEFT JOIN country c ON u.birthplace_id = c.id " +
                    "where u.NAME LIKE '%" + name + "%' AND u.surname LIKE '%" + surname + "%'");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean addUser(User u
    ) {
        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement("insert into user(name,surname,phone,email,profile_description,birthdate,address,password) values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getProfileDesc());
            stmt.setDate(6, u.getBirthDate());
            stmt.setString(7, u.getAddress());
            stmt.setString(8, getHash(u.getPassword()));
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return true;
        }
        return true;
    }

    @Override
    public User checkUserPassword(User user, String password) {
        boolean isLogin = verifyHash(password, user.getPassword());
        if (isLogin) {
            return user;
        } else {
            return null;
        }
    }

    private String getHash(String password) {
        BCrypt.Hasher crypt = BCrypt.withDefaults();
        String salt = "xeyal";
        password += salt;
        return crypt.hashToString(4, password.toCharArray());
    }

    private boolean verifyHash(String password, String hash) {
        String salt = "xeyal";
        password += salt;
        BCrypt.Verifyer verifyer = BCrypt.verifyer();
        BCrypt.Result result = verifyer.verify(password.getBytes(), hash.getBytes());
        return result.verified;
    }
//    @Override
//    public User getById(int userId) {
//        User result = null;
//        try (Connection conn = connect()) {
//            Statement stmt = conn.createStatement();
//            stmt.execute("select * from user where id=" + userId);
//            ResultSet rs = stmt.getResultSet();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String phone = rs.getString("phone");
//                String email = rs.getString("email");
//                result = new User(id, name, surname, phone, email, phone);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }

}
