package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.Country;
import pl.coderslab.sport_book.repository.CountryRepository;
import pl.coderslab.sport_book.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
   
    @Autowired
    CountryRepository countryRepository;
    
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
