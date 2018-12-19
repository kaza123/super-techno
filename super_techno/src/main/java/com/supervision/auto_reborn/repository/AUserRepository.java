/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.auto_reborn.repository;

import com.supervision.auto_reborn.domain.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author kasun
 */
public interface AUserRepository extends JpaRepository<AUser, Integer> {

    @Query(value = "select Users.IndexNo,\n"
            + "	Users.NAME,\n"
            + "	Users.PWORD,\n"
            + "	Users.type,\n"
            + "	Users.branch\n"
            + "from Users where Users.name=:userName", nativeQuery = true)
    public AUser findUser(@Param("userName") String userName);
   
    @Query(value = "select Users.IndexNo,\n"
            + "	Users.NAME,\n"
            + "	Users.PWORD,\n"
            + "	Users.type,\n"
            + "	Users.branch\n"
            + "from Users where Users.name=:userName \n"
            + "and Users.PWORD=:password and Users.branch=:branch", nativeQuery = true)
    public AUser findUser(@Param("userName") String userName,
            @Param("password") String password,
            @Param("branch") Integer branch);
    

}
