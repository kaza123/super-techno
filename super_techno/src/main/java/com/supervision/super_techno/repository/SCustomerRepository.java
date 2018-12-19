/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.super_techno.repository;

import com.supervision.super_techno.domain.SCustomer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kasun
 */
public interface SCustomerRepository extends JpaRepository<SCustomer, Integer> {

    @Query(value = "select Customer.CusNo,\n"
            + "	Customer.CusName,\n"
            + "	ISNULL(Customer.MobNo,'') as MobNo\n"
            + "from Customer", nativeQuery = true)
    public List<SCustomer> CustomerList();
}
