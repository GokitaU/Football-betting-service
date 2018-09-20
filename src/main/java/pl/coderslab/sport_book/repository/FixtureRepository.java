package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.betting.Fixture;
import pl.coderslab.sport_book.model.Team;

import java.util.List;

@Repository
public interface FixtureRepository extends JpaRepository<Fixture, Integer> {
    
    List<Fixture> findAllByAwayTeam(String team);

    List<Fixture> findAllByHomeTeam(String team);

    List<Fixture> findAllByMatchday(int matchday);

    List<Fixture> findAllByBetStatus(String status);

    Fixture getFirstByOrderByMatchdayDesc();

    Fixture save(Fixture fixture);



}
