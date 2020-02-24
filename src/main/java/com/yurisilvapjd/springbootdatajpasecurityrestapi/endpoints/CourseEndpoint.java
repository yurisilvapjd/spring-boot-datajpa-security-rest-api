package com.yurisilvapjd.springbootdatajpasecurityrestapi.endpoints;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Course;
import com.yurisilvapjd.springbootdatajpasecurityrestapi.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1")
public class CourseEndpoint {

    @Autowired
    GenericService<Course, Long> courseService;

    @GetMapping(path = "/protected/courses")
    public ResponseEntity<?> listAll(Pageable pageable) {

        return new ResponseEntity<>(courseService.listAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/protected/courses/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(courseService.verifiesIfExistsAndReturnsItById(id), HttpStatus.OK);
    }

    @PostMapping(path = "admin/courses")
    public ResponseEntity<?> save(@Valid @RequestBody Course course) {

        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }

    @DeleteMapping(path = "admin/courses/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "admin/courses")
    public ResponseEntity<?> update(@RequestBody Course course) {

        courseService.update(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/protected/courses/findbyname/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable("name") String name, Pageable pageable){
        return new ResponseEntity<>(courseService.findByName(name), HttpStatus.OK);
    }


}
