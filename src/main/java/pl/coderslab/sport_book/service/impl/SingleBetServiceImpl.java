package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.sport_book.model.betting.Fixture;
import pl.coderslab.sport_book.model.betting.SingleBet;
import pl.coderslab.sport_book.repository.SingleBetRepository;
import pl.coderslab.sport_book.service.FixtureService;
import pl.coderslab.sport_book.service.SingleBetService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SingleBetServiceImpl implements SingleBetService {

    @Autowired
    SingleBetRepository singleBetRepository;

    @Override
    public SingleBet save(SingleBet bet) {
       return singleBetRepository.save(bet);
    }

    @Override
    public SingleBet findById(Integer betId) {
        return singleBetRepository.findById(betId);
    }

    @Override
    public List<SingleBet> findAllByCouponId(int id) {
        return singleBetRepository.findAllByCouponId(id);
    }

    @Override
    public List<SingleBet> findAllByEventMatchday(int id) {
        return singleBetRepository.findAllByEventMatchday(id);
    }

    public static SingleBet getSingleBet(@RequestParam Integer event, @RequestParam BigDecimal betPrice, @RequestParam String placedBet, FixtureService fixtureService) {
        SingleBet bet=new SingleBet();
        Fixture fixture=fixtureService.findById(event);
        bet.setEvent(fixture);
        bet.setBetPrice(betPrice);
        bet.setPlacedBet(placedBet);

        return bet;
    }



}
