/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.controller;

import com.supervision.auto_reborn.domain.AUser;
import com.supervision.auto_reborn.service.ACommonService;
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
@RequestMapping("/security")
public class SecurityController {
    
    @Autowired
    private ACommonService commonService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AUser user(@RequestBody AUser user) {
        return commonService.user(user);
    }
}
