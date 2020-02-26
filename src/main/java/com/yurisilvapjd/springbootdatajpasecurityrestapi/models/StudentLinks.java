package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;

@Getter
public final class StudentLinks {

    private String createAndUpdate = "http://localhost:8080/v1/admin/students";
    private String getAll = "http://localhost:8080/v1/protected/students";
    private String getById = "http://localhost:8080/v1/protected/students{id}";
    private String searchByName = "http://localhost:8080/v1/protected/students/findbyname/{name}";
    private String delete = "http://localhost:8080/v1/protected/students{id}";

}
