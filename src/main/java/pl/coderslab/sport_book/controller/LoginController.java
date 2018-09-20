package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.service.UserDetailsService;

@Controller
public class LoginController {

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginRequest(Model model) {
        return "login";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String loginValidation(Model model, @RequestParam String username) {
//        User loggedUser= (User) userDetailsService.loadUserByUsername(username);
//
//        return "mock";
//    }

}
