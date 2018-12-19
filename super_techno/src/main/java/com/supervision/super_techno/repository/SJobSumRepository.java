/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.super_techno.repository;

import com.supervision.super_techno.domain.SVehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kasun
 */
@Repository
public interface SJobSumRepository extends JpaRepository<SVehicle, Integer>{
    
     @Query(value = "select JobSum.JobNo,\n"
            + "	JobSum.VehNo,\n"
            + "	JobSum.VMake,\n"
            + "	JobSum.VModel,\n"
            + "	JobSum.CusNo,\n"
            + "	JobSum.JobC\n"
            + "from JobSum", nativeQuery = true)
    public List<SVehicle> VehicleList();
}
