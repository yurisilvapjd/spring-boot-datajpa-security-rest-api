package com.yurisilvapjd.springbootdatajpasecurityrestapi.repositories;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    Optional<Page<Student>> findByNameIgnoreCaseContaining(String name, Pageable pageable);
}
