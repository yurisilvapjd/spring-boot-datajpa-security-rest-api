package com.yurisilvapjd.springbootdatajpasecurityrestapi.endpoints;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Student;
import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.TemplatedResponse;
import com.yurisilvapjd.springbootdatajpasecurityrestapi.services.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1")
public class StudentEndpoint {

    @Autowired
    StudentServiceInterface studentService;

    @GetMapping(path = "/protected/students")
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(new TemplatedResponse<Student>(Student.class, studentService.listAll(pageable)), HttpStatus.OK);
    }
    @GetMapping(path = "/protected/students/{id}")
    public ResponseEntity<?> getStudentsById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(studentService.verifiesIfExistsAndReturnsItById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/admin/students")
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {

        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    @DeleteMapping(path = "/admin/students/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {

        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/admin/students")
    public ResponseEntity<?> update(@RequestBody Student student) {

        studentService.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/protected/students/findbyname/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable("name") String name, Pageable pageable) {
        return new ResponseEntity<>(new TemplatedResponse<>(Student.class,studentService.findByName(name, pageable)), HttpStatus.OK);
    }

}
