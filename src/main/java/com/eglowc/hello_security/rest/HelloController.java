package com.eglowc.hello_security.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hclee on 2016-05-20.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return "Hello Security!";
    }
}
