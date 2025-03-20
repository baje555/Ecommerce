package com.example.demo.login.googleFbLog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/google")
public class GoogleController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    public Principal user(Principal user) {
        return user;
    }
}
