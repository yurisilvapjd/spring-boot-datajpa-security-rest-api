package com.yurisilvapjd.springbootdatajpasecurityrestapi.repositories;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    Optional<List<Student>> findByNameIgnoreCaseContaining(String name);
}
