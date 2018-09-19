package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.betting.BetCoupon;

@Repository
public interface BetCouponRepository extends JpaRepository <BetCoupon, Integer> {



}
