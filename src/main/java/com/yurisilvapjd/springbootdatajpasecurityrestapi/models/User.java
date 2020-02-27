package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class User extends AbstractEntity {

    @NotEmpty
    @Column(unique = true)
    private String username;
    @NotEmpty
    @JsonIgnore
    private String password;
    @NotEmpty
    private String name;
    private boolean admin;

    @Override
    public EntityEndpointLinks getAPILinks() {
        return null;
    }
}
