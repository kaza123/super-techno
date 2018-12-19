/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.auto_reborn.service;

import com.supervision.auto_reborn.domain.AVehicle;
import com.supervision.auto_reborn.domain.ACustomer;
import com.supervision.auto_reborn.domain.AJobDetail;
import com.supervision.auto_reborn.domain.AUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supervision.auto_reborn.repository.ACustomerRepository;
import com.supervision.auto_reborn.repository.AJobDetailRepository;
import com.supervision.auto_reborn.repository.AJobSumRepository;
import com.supervision.auto_reborn.repository.AUserRepository;

/**
 *
 * @author kasun
 */
@Service
public class ACommonService {

    @Autowired
    private AJobSumRepository jobSumRepository;
    
    @Autowired
    private AJobDetailRepository detailRepository;
    
    @Autowired
    private AUserRepository userRepository;
  
    @Autowired
    private ACustomerRepository customerRepository;
   
    public List<ACustomer> CustomerList() {
        return customerRepository.CustomerList();
    }
    
    public List<AVehicle> VehicleList() {
        return jobSumRepository.VehicleList();
    }
    
    public List<AJobDetail> DetailList(String jobNo) {
        return detailRepository.DetailList(jobNo);
    }
    
    public AUser user(AUser user) {
        return userRepository.findUser(user.getName(), user.getPassword(), user.getBranch());
    }

    public AJobDetail saveJobDetail(AJobDetail detail) {
        String date = detailRepository.getEnterDateByItemNo(detail.getItemNo());
        detail.setEnterDate(date);
        return detailRepository.save(detail);
        
    }

}
