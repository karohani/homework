package com.kakaopay.service;

import com.kakaopay.entity.Coupon;
import com.kakaopay.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository personRepositroy;

    @Override
    public Page<Coupon> loadAll(Pageable pageable) {

        return personRepositroy.findAll(pageable);

    }

    @Transactional
    public Coupon generateCoupon(String email) {
        // Email 체크

        try{

            Coupon coupon = digestEmail(email);
            return personRepositroy.save(coupon);

        }catch(DuplicateKeyException e){

            return collisionSaveStrategy(email);

        } catch(Exception e){

            return null;

        }

    }

    public Coupon digestEmail(String email) {

        StringTo16LengthMapping mapper = new StringTo16LengthMapping(email);
        Coupon coupon = new Coupon();
        coupon.setEmail(email);
        coupon.setCoupon(mapper.digest());
        return coupon;
    }

    public Coupon collisionSaveStrategy(String email) {

        StringTo16LengthMapping mapper = new StringTo16LengthMapping();
        String compressed;

        do{
            email += "a";
            mapper.setOrigin(email);
            compressed = mapper.digest();

        } while (isExistCoupon(compressed));

        return generateCoupon(email);
    }

    @Override
    public Boolean isExistCoupon(String coupon) {

        return personRepositroy.findByCoupon(coupon) != null;
    }

    @Override
    public Boolean isExistEmail(String email) {

        return personRepositroy.findByEmail(email) != null;
    }

    @Override
    public Coupon findEmail(String email) {

        return personRepositroy.findByEmail(email);
    }

}

