package com.yurisilvapjd.springbootdatajpasecurityrestapi.services;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.exceptions.ResourceNotFoundException;
import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Student;
import com.yurisilvapjd.springbootdatajpasecurityrestapi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student findById(Long id) {
        return verifiesIfExistsAndReturnsItById(id);
    }

    @Override
    public Page<Student> findByName(String name, Pageable pageable) {
        return studentRepository.findByNameIgnoreCaseContaining(name, pageable)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found for name: " + name));
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> listAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(verifiesIfExistsAndReturnsItById(student.getId()));
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(verifiesIfExistsAndReturnsItById(id));
    }

    @Override
    public boolean isUnique(Long id) {
        return false;
    }

    public Student verifiesIfExistsAndReturnsItById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Student not found for ID: " + id));
    }
}
