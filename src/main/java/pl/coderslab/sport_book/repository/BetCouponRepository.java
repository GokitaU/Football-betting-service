package pl.coderslab.sport_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.sport_book.model.betting.BetCoupon;

import java.util.List;

@Repository
public interface BetCouponRepository extends JpaRepository <BetCoupon, Integer> {

    List<BetCoupon> findAllByUser(String userName);


}
