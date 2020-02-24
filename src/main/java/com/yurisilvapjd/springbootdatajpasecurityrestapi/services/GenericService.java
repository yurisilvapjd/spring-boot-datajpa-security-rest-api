package com.yurisilvapjd.springbootdatajpasecurityrestapi.services;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T, ID>{

    T save(T t);

    T findById(ID id);

    void update(T t);

    void delete(ID id);

    Page<T> listAll(Pageable pageable);


    List<T> findByName(String name);

    T verifiesIfExistsAndReturnsItById(ID id);

    T verifiesIfExistsAndReturnsItByName(String name);

    boolean isUnique(Long id);

}
