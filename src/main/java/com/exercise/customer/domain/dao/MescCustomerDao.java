package com.exercise.customer.domain.dao;

import com.exercise.core.domain.GenericDao;
import com.exercise.customer.domain.model.MescCustomer;

public interface MescCustomerDao extends GenericDao<Long, MescCustomer> {

    MescCustomer findByName(String Name);
}
