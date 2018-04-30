package com.exercise.customer.domain.bussiness;

import com.exercise.customer.domain.model.MescCustomer;

import java.util.List;

public interface MescCustomerService {

    MescCustomer findCustomerByName(String name);
    List<MescCustomer> findCustomers();
    void addCustomer (MescCustomer customer);

}
