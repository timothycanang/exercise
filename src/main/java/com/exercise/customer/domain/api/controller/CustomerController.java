package com.exercise.customer.domain.api.controller;


import com.exercise.customer.domain.api.vo.Customer;
import com.exercise.customer.domain.bussiness.MescCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
@RequestMapping("api/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(Customer.class);
    private MescCustomerService customerService;


    @Autowired
    public CustomerController(MescCustomerService newService){
        this.customerService = newService;
    }

}
