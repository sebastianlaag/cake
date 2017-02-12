package de.laag.web;

import de.laag.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.laag.service.UserService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {
        final List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getDriver(Model model, @PathVariable(value="id") Long id) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "users";
    }

}
