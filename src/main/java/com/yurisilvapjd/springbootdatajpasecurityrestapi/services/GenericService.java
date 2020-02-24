package com.yurisilvapjd.springbootdatajpasecurityrestapi.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T, ID>{

    T findById(ID id);

    List<T> findByName(String name);

    T save(T t);

    Page<T> listAll(Pageable pageable);

    void update(T t);

    void delete(ID id);

    boolean isUnique(ID id);

    T verifiesIfExistsAndReturnsItById(ID id);

    T verifiesIfExistsAndReturnsItByName(String name);
}
