package pl.coderslab.sport_book.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.sport_book.model.betting.Market;
import pl.coderslab.sport_book.repository.MarketRepository;
import pl.coderslab.sport_book.repository.UserRepository;

public class MarketConverter implements Converter <String, Market> {

        @Autowired
        MarketRepository marketRepository;

        @Override
        public Market convert(String id) {
//            try {
                int marketId = Integer.parseInt(id);
                return marketRepository.findOne(marketId);
//            }catch (Exception e){
//                switch(id){
//                    case "H"
//                }
//            }
        }




}
