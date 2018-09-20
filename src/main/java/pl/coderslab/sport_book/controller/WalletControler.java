package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.model.Wallet;
import pl.coderslab.sport_book.model.betting.BetCoupon;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.repository.SingleBetRepository;
import pl.coderslab.sport_book.service.BetCouponService;
import pl.coderslab.sport_book.service.UserService;
import pl.coderslab.sport_book.service.WalletService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes ({"wallet","sessionBets"})
public class WalletControler {

    @Autowired
    UserService userService;

    @Autowired
    WalletService walletService;

    @Autowired
    BetCouponService couponService;

    @Autowired
    SingleBetRepository singleBetRepository;

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

    @RequestMapping (value = "/payfromaccount", method = RequestMethod.POST)
    public String payTheCoupon(@ModelAttribute ("wallet") Wallet wallet,
                               @ModelAttribute("sessionBets") List<SingleBet> sessionBets,
                               @RequestParam BigDecimal charge,
                               Authentication authentication,
                               HttpServletRequest request,
                               Model model){

      if( wallet.getBalance().compareTo(charge) < 0){
          return "moneyalert";
      }
      else {
          wallet.setBalance(wallet.getBalance().subtract(charge));
          HttpSession session = request.getSession();
          saveCoupon(sessionBets, charge, authentication, session);
          model.addAttribute("sessionBets", new ArrayList<>());

          return "mock";
      }

    }

    private void saveCoupon(@ModelAttribute("sessionBets") List<SingleBet> sessionBets, @RequestParam BigDecimal charge, Authentication authentication, HttpSession session) {
        User current=userService.getByUsername(authentication.getName());
        BetCoupon coupon = new BetCoupon();
        coupon.setBetValue(charge);
        coupon.setUser(current);

        couponService.save(coupon);

        List<SingleBet> bets = new ArrayList<>();
        for (SingleBet bet : sessionBets) {
            bet.setCoupon(coupon);
            singleBetRepository.save(bet);
            bets.add(bet);
        }
        BigDecimal winValue=calculateWinValue(bets,charge);
        coupon.setWinValue(winValue);
        coupon.setBets(bets);
        couponService.save(coupon);

    }


    private static BigDecimal calculateWinValue(List<SingleBet> bets, BigDecimal charge){

        BigDecimal win=charge;

        for(SingleBet bet:bets){
            win=win.multiply(bet.getBetPrice());
        }

        return win;
    }

}
