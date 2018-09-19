package pl.coderslab.sport_book.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.SingleBet;


public interface SingleBetService {

    SingleBet save(SingleBet bet);
    SingleBet findById(Integer betId);
}
