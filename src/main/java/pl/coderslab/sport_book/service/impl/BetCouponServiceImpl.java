package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.BetCoupon;
import pl.coderslab.sport_book.repository.BetCouponRepository;
import pl.coderslab.sport_book.service.BetCouponService;

@Service
public class BetCouponServiceImpl implements BetCouponService {
    @Autowired
    BetCouponRepository betCouponRepository;

    @Override
    public BetCoupon save(BetCoupon coupon) {
        return betCouponRepository.save(coupon);
    }
}
