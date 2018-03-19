package com.kakaopay.service;

import com.kakaopay.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CouponService {

    Page<Coupon> loadAll(Pageable paging);
    Coupon generateCoupon(String email);
    Boolean isExistCoupon(String coupon);
    Boolean isExistEmail(String email);
    Coupon findEmail(String email);
}
