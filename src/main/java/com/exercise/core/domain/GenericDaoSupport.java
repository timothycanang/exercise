package com.exercise.core.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;

public class GenericDaoSupport<K, I> implements GenericDao<K, I>, InitializingBean {


    public static final String WILDCARD = "%";
    private static final Logger LOG = LoggerFactory.getLogger(GenericDaoSupport.class);

    @Autowired(required = true)
    protected EntityManager entityManager;

    private Class<I> interfaceClass;
    private Class entityClass;

    public GenericDaoSupport(Class entityClass) {
        this.entityClass = entityClass;
    }

    public void afterPropertiesSet() throws Exception {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        interfaceClass = (Class<I>) genericSuperclass.getActualTypeArguments()[1];
    }


    public I newInstance() {

        try {
            return (I) entityClass.newInstance();
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }
        return null;
    }

    public I refresh(I i) {
        entityManager.refresh(i);
        return i;
    }

    public I findById(K k) {
        return (I) entityManager.getReference(entityClass, (Serializable) k);
    }

    public List<I> find() {
        Query query = entityManager.createQuery("select a "
                + " from " + entityClass.getName() + " a");
        return (List<I>) query.getResultList();
    }

    public List<I> find(Integer offset, Integer limit) {
        Query query = entityManager.createQuery("select a "
                + " from " + entityClass.getName() + " a");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<I>) query.getResultList();
    }



}
