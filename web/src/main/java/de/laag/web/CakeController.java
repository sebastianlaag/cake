package de.laag.web;

import java.util.List;

import de.laag.entities.Cake;
import de.laag.service.CakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.laag.entities.User;
import de.laag.service.UserService;

@Controller
@RequestMapping(value = "/cakes")
public class CakeController {

    @Autowired
    private CakeService cakeService;

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {
        final List<Cake> users = cakeService.getAllCakes();
        model.addAttribute("cakes", users);
        return "cakes";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getCake(Model model, @PathVariable(value="id") Long id) {
        Cake cake = cakeService.getCake(id);
        model.addAttribute("cake", cake);
        return "cake";
    }

}
