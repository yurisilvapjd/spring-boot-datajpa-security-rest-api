package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemplatedResponse<T extends AbstractEntity> {

    private List<T> content;
    private CustomPage page;
    private APILinks links;

}
