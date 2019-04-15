package com.example.bestpratices.resources;

import com.example.bestpratices.resources.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@RequestMapping("hello-world")
public class HelloWorldResource {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/internationalized")
    public String getHelloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false)  Locale locale) {
        return messageSource.getMessage("good.morning.message"
                ,null
                , locale);
    }

}
