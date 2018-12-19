/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision.super_techno.service;

import com.supervision.super_techno.domain.SCustomer;
import com.supervision.super_techno.domain.SJobDetail;
import com.supervision.super_techno.domain.SVehicle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.supervision.super_techno.repository.SCustomerRepository;
import com.supervision.super_techno.repository.SJobDetailRepository;
import com.supervision.super_techno.repository.SJobSumRepository;

/**
 *
 * @author kasun
 */
@Service
public class SCommonService {

    @Autowired
    public SJobSumRepository jobSumRepository;

    @Autowired
    private SCustomerRepository customerRepository;

    @Autowired
    private SJobDetailRepository detailRepository;

    public List<SCustomer> CustomerList() {
        return customerRepository.CustomerList();
    }

    public List<SVehicle> VehicleList() {
        return jobSumRepository.VehicleList();
    }

    public List<SJobDetail> DetailList(String jobNo) {
        return detailRepository.DetailList(jobNo);
    }

    public SJobDetail saveJobDetail(SJobDetail detail) {
        String date = detailRepository.getEnterDateByItemNo(detail.getItemNo());
        detail.setEnterDate(date);
        return detailRepository.save(detail);

    }
}
