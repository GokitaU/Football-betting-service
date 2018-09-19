package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Integer> {

    Role findByName(String role_user);
}
