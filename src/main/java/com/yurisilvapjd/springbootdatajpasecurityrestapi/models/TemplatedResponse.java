package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemplatedResponse<T> {

    List<T> content;
    CustomPage page;
    StudentLinks links;

    public TemplatedResponse() {
        this.links = new StudentLinks();
    }
}
