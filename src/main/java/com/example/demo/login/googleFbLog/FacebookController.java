package com.example.demo.login.googleFbLog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/facebook")
public class FacebookController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/login")
    public Principal facebook( Principal user){

        return user;
    }
}
