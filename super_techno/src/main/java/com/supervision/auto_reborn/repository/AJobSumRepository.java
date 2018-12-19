/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.auto_reborn.repository;

import com.supervision.auto_reborn.domain.AVehicle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kasun
 */
@Repository
public interface AJobSumRepository extends JpaRepository<AVehicle, Integer> {

    @Query(value = "select JobSum.JobNo,\n"
            + "	JobSum.VehNo,\n"
            + "	JobSum.VMake,\n"
            + "	JobSum.VModel,\n"
            + "	JobSum.CusNo,\n"
            + "	JobSum.JobC\n"
            + "from JobSum", nativeQuery = true)
    public List<AVehicle> VehicleList();

}
