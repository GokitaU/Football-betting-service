package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.User;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {

    User getByUsername(String username);
    User findByMail(String email);

}

