package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.model.Wallet;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.service.UserService;
import pl.coderslab.sport_book.service.WalletService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("wallet")
public class WalletControler {

    @Autowired
    UserService userService;

    @Autowired
    WalletService walletService;

    @ModelAttribute("wallet")
    public Wallet walletInSession(Authentication authentication){
        User current=userService.getByUsername(authentication.getName());
        Wallet wallet=current.getWallet();
        return wallet;
    }


    @RequestMapping ("/wallet")
    public String showUsersWallet(@ModelAttribute ("wallet") Wallet wallet){
        return "wallet";
    }


    @RequestMapping(value = "/chargeaccount", method = RequestMethod.GET)
    public String chargeWalletRequest(@ModelAttribute ("wallet") Wallet wallet){
        return "wallet-charge";

    }

    @RequestMapping(value = "/chargeaccount", method = RequestMethod.POST)
    public String chargeWalletProcessing(@ModelAttribute ("wallet") Wallet wallet, @RequestParam BigDecimal charge ){
        BigDecimal updatedBalance=wallet.getBalance().add(charge);
        wallet.setBalance(updatedBalance);
        walletService.saveWallet(wallet);
        return "redirect:/wallet";
    }
}
