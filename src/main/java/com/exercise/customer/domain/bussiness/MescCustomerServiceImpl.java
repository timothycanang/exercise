package com.exercise.customer.domain.bussiness;

import com.exercise.customer.domain.dao.MescCustomerDao;
import com.exercise.customer.domain.model.MescCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("customerService")
public class MescCustomerServiceImpl implements MescCustomerService{


    private static final Logger LOG = LoggerFactory.getLogger(MescCustomerServiceImpl.class);


    private MescCustomerDao customerDao;

    public MescCustomerServiceImpl(MescCustomerDao newCustomerDao){
    this.customerDao = newCustomerDao;
    }

    @Override
    public MescCustomer findCustomerByName(String name) {
        return customerDao.findByName(name);
    }

    @Override
    public List<MescCustomer> findCustomers() {
        return customerDao.find();
    }

    @Override
    public void addCustomer(MescCustomer customer) {
    }
}
