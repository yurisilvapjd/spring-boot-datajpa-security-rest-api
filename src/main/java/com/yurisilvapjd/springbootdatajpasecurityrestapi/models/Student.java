package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@ToString
public class Student extends AbstractEntity{

    @NotEmpty(message = "The field name must not be empty")
    private String name;
    @NotEmpty(message = "The field email must not be empty")
    @Email
    private String email;

    @Transient
    @JsonIgnore
    static final EntityEndpointLinks links = new EntityEndpointLinks(
            "http://localhost:8080/v1/admin/students",
            "http://localhost:8080/v1/protected/students{?page,size,sort}",
            "http://localhost:8080/v1/protected/students{id}",
            "http://localhost:8080/v1/protected/students/findbyname/{name}{?page,size,sort}",
            "http://localhost:8080/v1/admin/students{id}"
    );

    public Student() {
    }

    public Student(@NotEmpty(message = "The field name must not be empty") String name,
                   @NotEmpty(message = "The field email must not be empty") @Email String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    @JsonIgnore
    public EntityEndpointLinks getAPILinks() {
        return links;
    }
}
