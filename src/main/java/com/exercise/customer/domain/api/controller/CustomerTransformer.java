package com.exercise.customer.domain.api.controller;


import com.exercise.customer.domain.api.vo.Customer;
import com.exercise.customer.domain.bussiness.MescCustomerService;
import com.exercise.customer.domain.model.MescCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("customerTransformer")
public class CustomerTransformer {
    private MescCustomerService customerService;

    @Autowired
    public CustomerTransformer(MescCustomerService newCustomerService){
        this.customerService = newCustomerService;
    }

    public Customer toCustomerVo(MescCustomer e){
        if (null==e){
            Customer vo = new Customer();

            vo.setName(e.getName());
            vo.setContact(e.getContact());
            return vo;
        }
        return null;
    }

    public List<Customer> toCustomerVos(List<MescCustomer> e){
        List<Customer> vos = e.stream().map((e1)->toCustomerVo(e1)).collect(Collectors.toList());
        return  vos;
    }

}
