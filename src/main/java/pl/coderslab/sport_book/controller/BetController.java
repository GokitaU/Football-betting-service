package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.sport_book.model.betting.BetCoupon;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.service.BetCouponService;
import pl.coderslab.sport_book.service.SingleBetService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class BetController {

    @Autowired
    SingleBetService betService;

    @Autowired
    BetCouponService couponService;



    @PostMapping ("/bet/add")
    public String addBet(@Valid SingleBet bet, BindingResult result, HttpSession session, @RequestParam String event){
        BetCoupon betSlip= (BetCoupon) session.getAttribute("coupon");

        if (result.hasErrors()){
            return "redirect:/fixtures";
        }

        betSlip.addBet(bet);
        betService.save(bet);
        return "mock";

    }

}

