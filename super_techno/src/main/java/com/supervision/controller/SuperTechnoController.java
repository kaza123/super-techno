/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.controller;

import com.supervision.super_techno.domain.SCustomer;
import com.supervision.super_techno.domain.SJobDetail;
import com.supervision.super_techno.domain.SVehicle;
import com.supervision.super_techno.service.SCommonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kasun
 */
@RestController
@CrossOrigin
@RequestMapping("/api/sv/super")
public class SuperTechnoController {

    @Autowired
    private SCommonService commonService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<SCustomer> customer() {
        return commonService.CustomerList();
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public List<SVehicle> vehicle() {
        return commonService.VehicleList();
    }

    @RequestMapping(value = "/job-detail/{jobNo}", method = RequestMethod.GET)
    public List<SJobDetail> jobDetail(@PathVariable String jobNo) {
        return commonService.DetailList(jobNo);
    }

    @RequestMapping(value = "/save-job-detail", method = RequestMethod.POST)
    public SJobDetail saveJobDetail(@RequestBody SJobDetail detail) {
        return commonService.saveJobDetail(detail);
    }

}
