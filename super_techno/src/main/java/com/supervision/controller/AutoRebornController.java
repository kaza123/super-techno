/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.controller;

import com.supervision.auto_reborn.domain.AVehicle;
import com.supervision.auto_reborn.domain.ACustomer;
import com.supervision.auto_reborn.domain.AJobDetail;
import com.supervision.auto_reborn.domain.AUser;
import com.supervision.auto_reborn.service.ACommonService;
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
@RequestMapping("/api/sv/auto")
public class AutoRebornController {

    @Autowired
    private ACommonService commonService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<ACustomer> customer() {
        return commonService.CustomerList();
    }

    @RequestMapping(value = "/vehicle", method = RequestMethod.GET)
    public List<AVehicle> vehicle() {
        return commonService.VehicleList();
    }

    @RequestMapping(value = "/job-detail/{jobNo}", method = RequestMethod.GET)
    public List<AJobDetail> jobDetail(@PathVariable String jobNo) {
        return commonService.DetailList(jobNo);
    }

    @RequestMapping(value = "/save-job-detail", method = RequestMethod.POST)
    public AJobDetail saveJobDetail(@RequestBody AJobDetail detail) {
        return commonService.saveJobDetail(detail);
    }
}
