/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author xeyal
 */
public class User {

    private int id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private String address;
    private String profileDesc;
    private String phone;
    private Date birthDate;
    private Country nationality;
    private Country birthPlace;
    private boolean isAdmin;
    private List<UserSkill> skills;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public User(int id, String name, String surname, String password, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public User(int id, String name, String surname, String password, String email, String address, String profileDesc, String phone, Date birthDate, Country nationality, Country birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.profileDesc = profileDesc;
        this.phone = phone;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;

    }

    public User(int id, String name, String surname, String password, String email, String address, String profileDesc, String phone, Date birthDate, Country nationality, Country birthPlace, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.profileDesc = profileDesc;
        this.phone = phone;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    public String getProfileDesc() {
        return profileDesc;
    }

    public void setProfileDesc(String profileDesc) {
        this.profileDesc = profileDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", password=" + password + ", email=" + email + ", address=" + address + ", profileDesc=" + profileDesc + ", phone=" + phone + ", birthDate=" + birthDate + ", nationality=" + nationality + ", birthPlace=" + birthPlace + ", skills=" + skills +", isAdmin=" + isAdmin + '}';
    }
    

   
    

    

   

}
