package com.exercise.core.domain;

import java.util.List;

public interface GenericDao<K,I> {

    I newInstance();

    I refresh(I i);

    I findById(K k);

    List<I> find();

    List<I> find(Integer offset, Integer limit);



}
