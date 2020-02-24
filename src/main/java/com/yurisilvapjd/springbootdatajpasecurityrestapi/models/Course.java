package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
public class Course extends AbstractEntity {

    @NotEmpty(message = "The field name must not be empty")
    private String name;
    @NotNull(message = "The field courseLoad must not be empty")
    private Double courseLoad;

    public Course() {
    }

    public Course(@NotEmpty(message = "The field name must not be empty") String name, @NotNull(message = "The field courseLoad must not be empty") Double courseLoad) {
        this.name = name;
        this.courseLoad = courseLoad;
    }
}
