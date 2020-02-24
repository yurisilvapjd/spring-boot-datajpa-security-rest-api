package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@ToString
public class Student extends AbstractEntity {

    @NotEmpty(message = "The field name must not be empty")
    private String name;
    @NotEmpty(message = "The field email must not be empty")
    @Email
    private String email;

    public Student() {
    }

    public Student(@NotEmpty(message = "The field name must not be empty") String name, @NotEmpty(message = "The field email must not be empty") @Email String email) {
        this.name = name;
        this.email = email;
    }


}
