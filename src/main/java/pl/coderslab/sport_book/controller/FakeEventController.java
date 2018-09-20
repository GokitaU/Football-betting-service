package pl.coderslab.sport_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.sport_book.model.Country;
import pl.coderslab.sport_book.model.FootballLeague;
import pl.coderslab.sport_book.model.SportCategory;
import pl.coderslab.sport_book.model.Team;
import pl.coderslab.sport_book.model.betting.Fixture;
import pl.coderslab.sport_book.service.FixtureService;
import pl.coderslab.sport_book.service.TeamService;

import java.math.BigDecimal;
import java.util.*;

@Controller
public class FakeEventController {

    @Autowired
    FixtureService fixtureService;

    @Autowired
    TeamService teamService;

    @RequestMapping("/generate")
    public String generateFakeMatchday() {
        generateFakeMatchdaySchedule();
        return "mock";
    }

    @RequestMapping ("/fakeresults")
    public String generateFakeResults(){
        generateFakeMatchdayResults();
        return "mock";
    }


    private void generateFakeMatchdayResults() {
        Fixture fixture = fixtureService.getFirstByOrderByMatchdayDesc();
        int matchday = fixture.getMatchday();

        List<Fixture> fixtures=fixtureService.findAllByMatchday(matchday);
        for(Fixture f:fixtures){
            Random r=new Random();

            //away team scores
            f.setHTAG(r.nextInt(5));
            f.setFTAG(f.getHTAG()+r.nextInt(+5));

            //home team scores
            f.setHTHG(r.nextInt(5));
            f.setFTHG(f.getHTHG()+r.nextInt(+5));

            //halt time result
            if(f.getHTHG()>f.getHTAG()){
                f.setHTR('H');
            }
            else if (f.getHTHG()<f.getHTAG()){
                f.setHTR('A');
            }
            else {
                f.setHTR('D');
            }

            //final time result
            if(f.getFTHG()>f.getFTAG()){
                f.setFTR("H");
            }
            else if (f.getFTHG()<f.getFTAG()){
                f.setFTR("A");
            }
            else {
                f.setFTR("D");
            }
            f.setBetStatus("closed");

            fixtureService.save(f);

        }
    }


    private  void generateFakeMatchdaySchedule() {
        Fixture f = fixtureService.getFirstByOrderByMatchdayDesc();
        int matchday = f.getMatchday() + 1;
        Country country = f.getCountry();
        FootballLeague league = f.getLeague();
        FootballLeague divison = f.getDivision();
        SportCategory category = f.getCategory();

        List<Team> teams = teamService.findAll();
        Collections.shuffle(teams);
        List<Fixture> fixtures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Random random = new Random();
            Date date = new Date();

            //initialize empty event
            Fixture event = new Fixture();

            //select home and away team
            int x = random.nextInt(teams.size());
            int y = random.nextInt(teams.size());

            while (x == y) {
                y = random.nextInt(teams.size());
            }

            Team home = teams.get(x);
            Team away = teams.get(y);

            //generate random odds
            double leftLimit = 1D;
            double rightLimit = 10D;
            double generatedDouble = leftLimit + new Random().nextDouble() * (rightLimit - leftLimit);

            //set fixture attributes
            event.setAwayTeam(away);
            event.setHomeTeam(home);
            event.setBetAway(BigDecimal.valueOf(generatedDouble));
            event.setBetHome(BigDecimal.valueOf(generatedDouble));
            event.setBetDraw(BigDecimal.valueOf(generatedDouble));
            event.setGoalsLessThan25(BigDecimal.valueOf(generatedDouble));
            event.setGoalsMoreThan25(BigDecimal.valueOf(generatedDouble));
            event.setLeague(league);
            event.setCountry(country);
            event.setDate(date);
            event.setMatchday(matchday);
            event.setReferee("Andy Powell");
            event.setBetStatus("active");
            event.setCategory(category);
            fixtures.add(event);
        }

        for (Fixture fix : fixtures) {
            fixtureService.save(fix);
        }
    }

}
