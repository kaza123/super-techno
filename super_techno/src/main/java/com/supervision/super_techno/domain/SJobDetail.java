/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.super_techno.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kasun
 */
@Entity
@Table(name = "JobDet")
public class SJobDetail implements Serializable{
    
    @Id
    @Column(name = "ItemNo")
    private String ItemNo; 
   
    @Column(name = "ProNo")
    private String ProNo; 
   
    @Column(name = "PDes")
    private String PDes; 
   
    @Column(name = "qty")
    private BigDecimal qty; 
   
    @Column(name = "UPrice")
    private BigDecimal UPrice; 
   
    @Column(name = "Val")
    private BigDecimal Val; 
   
    @Column(name = "purchase_price")
    private BigDecimal purchasePrice; 
   
    @Column(name = "purchase_discount")
    private BigDecimal purchaseDiscount; 
   
    @Column(name = "login_user")
    private String loginUser; 
   
    @Column(name = "is_user_update")
    private Integer isUserUpdate; 
   
    @Column(name = "user_date")
    private String userDate; 
   
    @Column(name = "is_approve")
    private Integer isApprove; 
   
    @Column(name = "admin_date")
    private String adminDate; 
   
    @Column(name = "is_admin_update")
    private Integer isAdminUpdate; 
    
    @Column(name = "enter_date")
    private String enterDate; 

    public SJobDetail() {
    }

    public String getItemNo() {
        return ItemNo;
    }

    public void setItemNo(String ItemNo) {
        this.ItemNo = ItemNo;
    }

    public String getProNo() {
        return ProNo;
    }

    public void setProNo(String ProNo) {
        this.ProNo = ProNo;
    }

    public String getPDes() {
        return PDes;
    }

    public void setPDes(String PDes) {
        this.PDes = PDes;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public BigDecimal getUPrice() {
        return UPrice;
    }

    public void setUPrice(BigDecimal UPrice) {
        this.UPrice = UPrice;
    }

    public BigDecimal getVal() {
        return Val;
    }

    public void setVal(BigDecimal Val) {
        this.Val = Val;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getPurchaseDiscount() {
        return purchaseDiscount;
    }

    public void setPurchaseDiscount(BigDecimal purchaseDiscount) {
        this.purchaseDiscount = purchaseDiscount;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public Integer getIsUserUpdate() {
        return isUserUpdate;
    }

    public void setIsUserUpdate(Integer isUserUpdate) {
        this.isUserUpdate = isUserUpdate;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public Integer getIsApprove() {
        return isApprove;
    }

    public void setIsApprove(Integer isApprove) {
        this.isApprove = isApprove;
    }

    public String getAdminDate() {
        return adminDate;
    }

    public void setAdminDate(String adminDate) {
        this.adminDate = adminDate;
    }

    public Integer getIsAdminUpdate() {
        return isAdminUpdate;
    }

    public void setIsAdminUpdate(Integer isAdminUpdate) {
        this.isAdminUpdate = isAdminUpdate;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }
    
}
