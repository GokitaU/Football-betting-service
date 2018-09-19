package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.sport_book.model.betting.BetCoupon;
import pl.coderslab.sport_book.model.betting.Fixture;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.service.FixtureService;
import pl.coderslab.sport_book.service.SingleBetService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static pl.coderslab.sport_book.service.impl.SingleBetServiceImpl.getSingleBet;

@Controller
@SessionAttributes("sessionBets")
public class Bet2Controller {

    @Autowired
    SingleBetService singleBetService;

    @Autowired
    FixtureService fixtureService;

    @PostMapping ("/newbet")
    public String addBetToCoupon(@RequestParam Integer event,
                         @RequestParam BigDecimal betPrice,
                         @RequestParam String placedBet,
                         HttpSession session) {

        //converter was not working
        SingleBet bet = getSingleBet(event, betPrice, placedBet, fixtureService);

        List<SingleBet> betsInSession= (List<SingleBet>) session.getAttribute("sessionBets");

        if (bet.checkIfUniqe(betsInSession)==false){
            return "redirect:/fixtures";
        }

        betsInSession.add(bet);
        return "coupon";
    }

    @PostMapping ("/delbet")
    public String deleteBetFromCoupon(@RequestParam Integer event,
                                      @ModelAttribute("sessionBets") List<SingleBet> sessionBets){

        removeBetFromSession(event, sessionBets);

        return "coupon";

    }




    private void removeBetFromSession(@RequestParam Integer event, @ModelAttribute("sessionBets") List<SingleBet> sessionBets) {
        Iterator<SingleBet> iterator=sessionBets.listIterator();
        while (iterator.hasNext()){
            if (iterator.next().getEvent().getId()== event){
                iterator.remove();
            }
        }
    }


}
