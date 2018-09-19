package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.Fixture;
import pl.coderslab.sport_book.model.Team;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.repository.FixtureRepository;
import pl.coderslab.sport_book.service.FixtureService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FixtureServiceImpl implements FixtureService {
    @Autowired
    FixtureRepository fixtureRepository;

    @Override
    public List<Fixture> findAll() {
        return fixtureRepository.findAll();
    }

    @Override
    public List<Fixture> findAllByAwayTeam(String team) {
        return fixtureRepository.findAllByAwayTeam(team);
    }

    @Override
    public List<Fixture> findAllByHomeTeam(String team) {
        return fixtureRepository.findAllByHomeTeam(team);
    }

    @Override
    public List<Fixture> findAllByAwayTeam(Team team) {
        return findAllByAwayTeam(team);
    }

    @Override
    public List<Fixture> findAllByHomeTeam(Team team) {
        return findAllByHomeTeam(team);
    }

    @Override
    public List<Fixture> findAllByMatchday(int matchday) {
        return fixtureRepository.findAllByMatchday(matchday);
    }

    @Override
    public List<Fixture> findAllByBetStatus(String status) {
        return fixtureRepository.findAllByBetStatus(status);
    }

    @Override
    public Fixture findById(int fixId) {
        return fixtureRepository.findOne(fixId);
    }

}
