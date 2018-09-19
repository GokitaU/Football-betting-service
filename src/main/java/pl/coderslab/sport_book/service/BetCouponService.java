package pl.coderslab.sport_book.service;

import pl.coderslab.sport_book.model.betting.BetCoupon;

import java.util.List;

public interface BetCouponService {

    BetCoupon save(BetCoupon coupon);
    List<BetCoupon> findAllByUser(String userName);
}
