package com.example.bestpratices.resources;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Data;

@Data
@JsonFilter("SomeBeanFilter")
public class BeanExample {

    private String field1;
    private String field2;
    private String field3;
}
