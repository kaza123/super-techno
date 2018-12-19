/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.auto_reborn.repository;

import com.supervision.auto_reborn.domain.ACustomer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author kasun
 */
public interface ACustomerRepository extends JpaRepository<ACustomer, Integer> {

    @Query(value = "select Customer.CusNo,\n"
            + "	Customer.CusName,\n"
            + "	ISNULL(Customer.MobNo,'') as MobNo\n"
            + "from Customer", nativeQuery = true)
    public List<ACustomer> CustomerList();
}
