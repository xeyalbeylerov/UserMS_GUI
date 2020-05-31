/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;
import com.company.entity.UserSkill;
import java.util.List;

/**
 *
 * @author TURAL
 */
public interface UserSkillDaoInter {
    List<UserSkill> getAllSkillByUserId(int id);
    boolean insertUserSkill(UserSkill u);
    boolean updateUserSkill(UserSkill u);
    boolean removeUserSkill(int id);
}
