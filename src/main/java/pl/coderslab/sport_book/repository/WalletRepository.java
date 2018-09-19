package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Wallet findByOwner(User user);
}
