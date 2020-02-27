package com.yurisilvapjd.springbootdatajpasecurityrestapi.models;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class TemplatedResponse<T extends AbstractEntity> {

    private List<T> content;
    private CustomPage page;
    private EntityEndpointLinks endpointLinks;

    public TemplatedResponse() {
    }

    public TemplatedResponse(Class<T> clazz, Page<T> page) {

        this.content = page.getContent();
        this.page = new CustomPage(page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber());

        try {
            this.endpointLinks = clazz.getConstructor().newInstance().getAPILinks();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
