package com.yurisilvapjd.springbootdatajpasecurityrestapi.services;

import com.yurisilvapjd.springbootdatajpasecurityrestapi.models.Student;

public interface StudentServiceInterface extends GenericService<Student, Long> {

    Student verifiesIfExistsAndReturnsItById(Long id);
}
