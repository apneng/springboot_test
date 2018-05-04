package com.ggy.springboot.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/userCtrl")
public class Hello {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String hello(){
        return "index";
    }

    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
}
