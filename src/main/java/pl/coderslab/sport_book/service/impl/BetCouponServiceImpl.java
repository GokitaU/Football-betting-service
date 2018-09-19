package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.betting.BetCoupon;
import pl.coderslab.sport_book.repository.BetCouponRepository;
import pl.coderslab.sport_book.service.BetCouponService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BetCouponServiceImpl implements BetCouponService {
    @Autowired
    BetCouponRepository betCouponRepository;

    @Override
    public BetCoupon save(BetCoupon coupon) {
        return betCouponRepository.save(coupon);
    }

    @Override
    public List<BetCoupon> findAllByUser(String userName) {

        List<BetCoupon> coupons=new ArrayList<>();

        try {
            coupons= betCouponRepository.findAllByUser(userName);
        } catch (Exception e) {

        }

        return  coupons;
    }
}
