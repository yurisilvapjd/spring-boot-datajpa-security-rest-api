package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class APILinks {

    private String createAndUpdate;
    private String getAll;
    private String getById;
    private String search;
    private String delete;

    public APILinks(String createAndUpdate, String getAll, String getById, String search, String delete) {
        this.createAndUpdate = createAndUpdate;
        this.getAll = getAll;
        this.getById = getById;
        this.search = search;
        this.delete = delete;
    }
}
