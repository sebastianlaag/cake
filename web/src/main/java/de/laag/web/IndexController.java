package de.laag.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    private String message = "Hello World";

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        model.put("username", this.message);
        return "index";
    }

}