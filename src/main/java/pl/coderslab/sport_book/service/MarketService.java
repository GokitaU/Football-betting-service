package pl.coderslab.sport_book.service;

import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.Market;

import java.util.List;

@Service
public interface MarketService {
    List<Market> findAll();

}
