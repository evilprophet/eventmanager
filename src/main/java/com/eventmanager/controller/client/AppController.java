package com.eventmanager.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("ClientAppController")
public class AppController {

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public String indexAction() {
        return "client/app/index";
    }

}
