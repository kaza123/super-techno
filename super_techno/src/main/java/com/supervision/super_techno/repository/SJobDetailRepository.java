/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.super_techno.repository;

import com.supervision.super_techno.domain.SJobDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author kasun
 */
public interface SJobDetailRepository extends JpaRepository<SJobDetail, Integer> {

     @Query(value = "select JobDet.ItemNo,\n"
            + "	JobDet.ProNo,\n"
            + "	JobDet.PDes,\n"
            + "	JobDet.Qty,\n"
            + "	JobDet.UPrice,\n"
            + "	JobDet.Val,\n"
            + "	JobDet.purchase_price,\n"
            + "	JobDet.purchase_discount,\n"
            + "	JobDet.login_user,\n"
            + "	JobDet.is_user_update,\n"
            + "	JobDet.user_date,\n"
            + "	JobDet.is_approve,\n"
            + "	JobDet.admin_date,\n"
            + "	JobDet.is_admin_update,\n"
            + "	DATEDIFF(day, JobDet.enter_date,GETDATE()) as enter_date\n"
            + "from JobDet\n"
            + "where JobDet.JobNo=:jobNo and JobDet.is_approve=1", nativeQuery = true)
    public List<SJobDetail> DetailList(@Param("jobNo") String jobNo);

    @Query(value = "select enter_date from JobDet where ItemNo=:itemNo", nativeQuery = true)
    public String getEnterDateByItemNo(@Param("itemNo")String itemNo);
}
