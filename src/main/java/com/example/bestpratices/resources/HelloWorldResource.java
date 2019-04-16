package com.example.bestpratices.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("hello-world")
public class HelloWorldResource {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/internationalizesd")
    public String getHelloWorldInternationalized(@RequestHeader(name="Accept-Language", required = false)  Locale locale) {
        return messageSource.getMessage("good.morning.message",null, locale);
    }

    @GetMapping("/internationalized-context")
    public String getHelloWorldInternationalizedContext() {
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }

}
