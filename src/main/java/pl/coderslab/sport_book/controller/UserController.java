package pl.coderslab.sport_book.controller;

import com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.service.UserDetailsService;
import pl.coderslab.sport_book.service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/account")
    public String userAccountDetails(Model model, Authentication authentication){

        User current=userService.getByUsername(authentication.getName());
        model.addAttribute("user", current);
        return "user-account";
    }
}
