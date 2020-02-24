package com.yurisilvapjd.springbootdatajpasecurityrestapi.repositories;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    Course findByName(String name);

    List<Course> findByNameIgnoreCaseContaining(String name);
}
