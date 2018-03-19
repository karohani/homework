package com.kakaopay.controller;


import com.kakaopay.entity.Coupon;
import com.kakaopay.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.validator.routines.EmailValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.List;
import java.util.Map;


@CrossOrigin("*")
@RestController
public class CouponController {

    @Autowired
    private CouponService couponService;


    @RequestMapping(value="/coupon", method = RequestMethod.POST)
    public ResponseEntity<Coupon> insert(@RequestBody Map<String, Object> payload,
                                         HttpServletRequest request, HttpServletResponse response){

        String email = (String) payload.get("email");

        if (!EmailValidator.getInstance().isValid(email)){
            return new ResponseEntity<>(new Coupon(), HttpStatus.BAD_REQUEST);
        }

        if(couponService.isExistEmail(email)){
            // Exception 응답코드 , Response Entity
            return new ResponseEntity<>(new Coupon(), HttpStatus.BAD_REQUEST);
        }

        Coupon coupon = couponService.generateCoupon(email);

        if (coupon == null){
            // 기타등등.....
            return new ResponseEntity<>(new Coupon(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return new ResponseEntity<>(coupon, HttpStatus.OK);
    }

    @RequestMapping(value="/coupon", method= RequestMethod.GET)
    public List<Coupon> getA(@RequestParam("page") int page){
        page -= 1;
        Pageable paging = PageRequest.of(page, 10);
        Page<Coupon> result = couponService.loadAll(paging);
        return result.getContent();

    }

    @RequestMapping(value="/find/{string}", method = RequestMethod.GET)
    public String coupon(@PathVariable String string){
        Coupon coupon = couponService.findEmail(string);
        return coupon.toString();
    }



    @RequestMapping(value="/coupon/max", method = RequestMethod.GET)
    public int totalNum(){
        Pageable paging = PageRequest.of(0, 10);
        Page<Coupon> result = couponService.loadAll(paging);
        return result.getNumberOfElements();
    }
}
