package com.yurisilvapjd.springbootdatajpasecurityrestapi.repositories;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    Student findByName(String name);

    List<Student> findByNameIgnoreCaseContaining(String name);
}
