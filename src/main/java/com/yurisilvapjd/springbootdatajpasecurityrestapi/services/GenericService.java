package com.yurisilvapjd.springbootdatajpasecurityrestapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenericService<T, ID>{

    T save(T t);

    T findById(ID id);

    void update(T t);

    void delete(ID id);

    Page<T> listAll(Pageable pageable);

    Page<T> findByName(String name, Pageable pageable);

    boolean isUnique(Long id);

}
