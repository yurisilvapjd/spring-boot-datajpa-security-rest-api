package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomPage {

    private int size;
    private long totalElements;
    private int totalPages;
    private int number;

    public CustomPage() {
    }

    public CustomPage(int size, long totalElements, int totalPages, int number) {
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.number = number;
    }
}
