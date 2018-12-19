/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.super_techno.domain;

import com.supervision.auto_reborn.domain.*;
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
@Table(name = "Customer")
public class SCustomer implements Serializable{
    
    @Id
    @Column(name = "CusNo")
    private String CusNo;
    
    @Column(name = "CusName")
    private String CusName;
    
    @Column(name = "MobNo")
    private String MobNo;

    public SCustomer() {
    }

    public String getCusNo() {
        return CusNo;
    }

    public void setCusNo(String CusNo) {
        this.CusNo = CusNo;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public String getMobNo() {
        return MobNo;
    }

    public void setMobNo(String MobNo) {
        this.MobNo = MobNo;
    }
    
}
