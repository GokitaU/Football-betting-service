//package pl.coderslab.sport_book.converter;
//
//import io.swagger.models.auth.In;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.convert.converter.Converter;
//import pl.coderslab.sport_book.model.betting.Fixture;
//import pl.coderslab.sport_book.repository.FixtureRepository;
//
//public class FixtureConverter implements Converter <String, Fixture> {
//
//    @Autowired
//    FixtureRepository fixtureRepository;
//
//    @Override
//    public Fixture convert(String id) {
//        int fixId= Integer.parseInt(id);
//        return fixtureRepository.findOne(fixId);
//    }
//}
