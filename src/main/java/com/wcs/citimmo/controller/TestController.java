package com.wcs.citimmo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping({ "/testing" })
    public String welcomePage() {
        return "Welcome!";
    }
}
