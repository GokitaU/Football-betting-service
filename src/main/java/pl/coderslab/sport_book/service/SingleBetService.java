package pl.coderslab.sport_book.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.SingleBet;

import java.util.List;


public interface SingleBetService {

    SingleBet save(SingleBet bet);
    SingleBet findById(Integer betId);

    List<SingleBet> findAllByCouponId(int id);
    List<SingleBet> findAllByEventMatchday(int id);
}
