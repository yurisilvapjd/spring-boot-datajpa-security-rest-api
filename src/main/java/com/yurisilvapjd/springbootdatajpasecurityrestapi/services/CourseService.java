package com.yurisilvapjd.springbootdatajpasecurityrestapi.services;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.exceptions.ResourceNotFoundException;
import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Course;
import com.yurisilvapjd.springbootdatajpasecurityrestapi.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements GenericService<Course, Long> {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public Course findById(Long id) {

        return verifiesIfExistsAndReturnsItById(id);
    }

    @Override
    public List<Course> findByName(String name) {

        return courseRepository.findByNameIgnoreCaseContaining(name);
    }

    @Override
    public Course save(Course course) {

        return courseRepository.save(course);
    }

    @Override
    public Page<Course> listAll(Pageable pageable) {

        return courseRepository.findAll(pageable);
    }

    @Override
    public void update(Course course) {

        Course toBeUpdated = verifiesIfExistsAndReturnsItByName(course.getName());

        if(toBeUpdated == null){
            throw new ResourceNotFoundException("Course not found for the given information");
        }

        toBeUpdated.setName(course.getName());
        toBeUpdated.setCourseLoad(course.getCourseLoad());
        courseRepository.save(toBeUpdated);
    }

    @Override
    public void delete(Long id) {

        courseRepository.delete(verifiesIfExistsAndReturnsItById(id));
    }

    @Override
    public boolean isUnique(Long id) {

        return false;
    }

    @Override
    public Course verifiesIfExistsAndReturnsItById(Long id) {

        return courseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Course not found for ID: " + id));
    }

    @Override
    public Course verifiesIfExistsAndReturnsItByName(String name) {

        return Optional.ofNullable(courseRepository.findByName(name))
                .orElseThrow(()-> new ResourceNotFoundException("Course not found with the name: " + name));
    }
}
