package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.sport_book.model.betting.BetCoupon;
import pl.coderslab.sport_book.model.betting.Fixture;
import pl.coderslab.sport_book.model.betting.Market;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.service.FixtureService;
import pl.coderslab.sport_book.service.MarketService;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes ("sessionBets")
public class HomeController {

    @Autowired
    FixtureService fixtureService;

    @Autowired
    MarketService marketService;

        @GetMapping("/home")
        public String home(Model model, @ModelAttribute("sessionBets") List<SingleBet> sessionBets) {

            String username = SecurityContextHolder.getContext().getAuthentication().getName();

            System.out.println("Username");
            System.out.println(username);

            List<Fixture> activeFixtures=fixtureService.findAllByBetStatus("active");

            SingleBet singleBet=new SingleBet();

            model.addAttribute("active", activeFixtures);
            model.addAttribute("singlBet", singleBet);

            return "default_layout";
        }


        @GetMapping("/results")
        public String showResults(Model model){

            List<Fixture> finishedFixtures=fixtureService.findAllByBetStatus("closed");

            model.addAttribute("finishedGames", finishedFixtures);

            return "results";
        }


        @ModelAttribute("sessionBets")
        public List<SingleBet> betsInSession(){
            return new ArrayList<>();
        }

        @GetMapping("/admin")
        @ResponseBody
        public String admin() { return "admin"; }
    }


