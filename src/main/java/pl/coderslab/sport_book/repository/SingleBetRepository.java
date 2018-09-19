package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.sport_book.model.betting.SingleBet;

public interface SingleBetRepository extends JpaRepository <SingleBet, Integer> {


    SingleBet findById(Integer betId);
}
