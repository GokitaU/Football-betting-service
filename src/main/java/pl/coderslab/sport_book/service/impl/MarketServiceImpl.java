package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.Market;
import pl.coderslab.sport_book.repository.MarketRepository;
import pl.coderslab.sport_book.service.MarketService;

import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    MarketRepository marketRepository;

    @Override
    public List<Market> findAll() {
        return marketRepository.findAll();
    }
}
