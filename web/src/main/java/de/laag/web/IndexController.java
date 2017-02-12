package de.laag.web;

import java.util.Map;

import de.laag.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private LoginService loginService;

    private String message = "Hello World";

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        loginService.login("Jack", "Bauer");
        model.put("username", this.message);
        return "index";
    }

}
