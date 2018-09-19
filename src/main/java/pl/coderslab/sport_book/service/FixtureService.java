package pl.coderslab.sport_book.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.Fixture;
import pl.coderslab.sport_book.model.Team;

import java.util.List;


public interface FixtureService {

    List<Fixture> findAll();
    List<Fixture> findAllByAwayTeam(String team);
    List<Fixture> findAllByHomeTeam(String team);

    List<Fixture> findAllByAwayTeam(Team team);
    List<Fixture> findAllByHomeTeam(Team team);

    List<Fixture> findAllByMatchday(int matchday);
    List<Fixture> findAllByBetStatus(String status);

    Fixture findById(int fixId);

}
