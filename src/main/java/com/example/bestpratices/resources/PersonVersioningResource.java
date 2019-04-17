package com.example.bestpratices.resources;

import com.example.bestpratices.resources.dto.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonVersioningResource {

    @GetMapping("/v1/person")
    public PersonV2 personV1(){
        return new PersonV2();
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return new PersonV2();
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2(){
        return new PersonV2();
    }

    @GetMapping(value = "/person/headers", headers = "X-API_VERSION=2")
    public PersonV2 readerV2(){
        return new PersonV2();
    }
}
