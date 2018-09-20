package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.sport_book.model.betting.BetCoupon;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.service.BetCouponService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("sessionBets")
public class CouponController {

    @Autowired
    BetCouponService couponService;

    protected List<SingleBet> sessionBets;

    @RequestMapping("/mycoupon")
    public String showMyCoupon() {

        return "coupon";
    }


    @RequestMapping ("/mycoupons")
    public String myBets(Model model, Authentication authentication){
        String userName=authentication.getName();
//        List<BetCoupon> coupons=couponService.findAllByUser(userName);
        List<BetCoupon> coupons=couponService.findAllByUserUsername(userName);
        model.addAttribute("coupons", coupons);
        return "mybets";
    }


    @RequestMapping("/coupondetails")
    public  String showCouponDetails(){

        return "mock";
    }



}


