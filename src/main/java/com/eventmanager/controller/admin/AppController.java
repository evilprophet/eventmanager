package com.eventmanager.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller("AdminAppController")
@RequestMapping("/admin")
@SessionAttributes("roles")
public class AppController {

    @RequestMapping(value = {"", "/index"}, method = RequestMethod.GET)
    public String indexAction() {
        return "admin/app/index";
    }

}
