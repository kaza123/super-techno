/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.super_techno.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kasun
 */
@Entity
@Table(name = "JobSum")
public class SVehicle implements  Serializable{
    @Id
    @Column(name = "JobNo")
    private String JobNo;
    
    @Column(name = "CusNo")
    private String CusNo;
    
    @Column(name = "VehNo")
    private String VehNo;
    
    @Column(name = "VMake")
    private String VMake;
    
    @Column(name = "VModel")
    private String VModel;
    
    @Column(name = "JobC")
    private String JobC;
    
    public SVehicle() {
    }

    public SVehicle(String JobNo, String CusNo, String VehNo, String VMake, String VModel) {
        this.JobNo = JobNo;
        this.CusNo = CusNo;
        this.VehNo = VehNo;
        this.VMake = VMake;
        this.VModel = VModel;
    }

    public String getJobNo() {
        return JobNo;
    }

    public void setJobNo(String JobNo) {
        this.JobNo = JobNo;
    }

    public String getCusNo() {
        return CusNo;
    }

    public void setCusNo(String CusNo) {
        this.CusNo = CusNo;
    }

    public String getVehNo() {
        return VehNo;
    }

    public void setVehNo(String VehNo) {
        this.VehNo = VehNo;
    }

    public String getVMake() {
        return VMake;
    }

    public void setVMake(String VMake) {
        this.VMake = VMake;
    }

    public String getVModel() {
        return VModel;
    }

    public void setVModel(String VModel) {
        this.VModel = VModel;
    }

    public String getJobC() {
        return JobC;
    }

    public void setJobC(String JobC) {
        this.JobC = JobC;
    }

   
   
}
