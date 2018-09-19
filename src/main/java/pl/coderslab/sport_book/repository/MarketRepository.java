package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.betting.Market;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository <Market, Integer> {

}
