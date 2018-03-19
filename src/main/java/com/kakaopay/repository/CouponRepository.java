package com.kakaopay.repository;


import com.kakaopay.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    Coupon findByCoupon(String coupon);
    Coupon findByEmail(String email);

}
