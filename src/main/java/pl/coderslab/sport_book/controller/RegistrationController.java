package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.sport_book.model.Country;
import pl.coderslab.sport_book.model.DTO.UserDTO;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.model.Wallet;
import pl.coderslab.sport_book.service.CountryService;
import pl.coderslab.sport_book.service.UserDetailsService;
import pl.coderslab.sport_book.service.UserService;
import pl.coderslab.sport_book.service.WalletService;
import pl.coderslab.sport_book.service.impl.UserDetailsServiceImpl;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    CountryService countryService;

    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    WalletService walletService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerNewUser(Model model){

        List<Country> countries=countryService.findAll();

        UserDTO userDTO=new UserDTO();

        model.addAttribute("userDTO", userDTO);
        model.addAttribute("countries", countries);
        return "registration";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveNewUser(@Valid UserDTO userDTO, BindingResult result){

        if (!result.hasErrors() && findIfUserCredentialsAreFree(userDTO)==true){
            saveUser(userDTO);
            return "mock";
        }
        return "registration";
    }

    private void saveUser(@Valid UserDTO userDTO) {
        Wallet wallet=userDTO.getWallet();
        wallet.setBalance(BigDecimal.valueOf(0));
//        walletService.saveWallet(wallet);

        User user=userDTO.getUser();
        user.setWallet(wallet);
        userService.saveUser(user);
    }

    private boolean findIfUserCredentialsAreFree(@Valid UserDTO userDTO) {
        String userName=userDTO.getUser().getUsername();
        String email=userDTO.getUser().getMail();
        boolean dataBaseVerification=userDetailsService.findEmailAndUsername(userName,email);
        return dataBaseVerification;
    }
}
