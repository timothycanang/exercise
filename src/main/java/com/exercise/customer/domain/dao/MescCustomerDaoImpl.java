package com.exercise.customer.domain.dao;

import com.exercise.core.domain.GenericDaoSupport;
import com.exercise.customer.domain.model.MescCustomer;
import com.exercise.customer.domain.model.MescCustomerImpl;


import org.springframework.stereotype.Repository;
import javax.persistence.Query;

@Repository("mescCustomerDao")
public class MescCustomerDaoImpl extends GenericDaoSupport<Long, MescCustomer> implements MescCustomerDao{



    public MescCustomerDaoImpl(){
        super(MescCustomerImpl.class);
    }

    @Override
    public MescCustomer findByName(String Name) {
        Query query = entityManager.createQuery("select a from mescCustomer a where" +
                " a.customerName = :newName");
        query.setParameter("newName",Name);
        return (MescCustomer)query.getSingleResult();
    }
}
