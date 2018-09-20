package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository <Team, Integer> {

    List<Team> findAll();

}
