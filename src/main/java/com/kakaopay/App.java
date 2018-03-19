package com.kakaopay;

import com.kakaopay.entity.Coupon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.kakaopay.repository.CouponRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class App {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

		CouponRepository couponRepository = context.getBean(CouponRepository.class);
		Coupon testCoupon = new Coupon();
		testCoupon.setEmail("mail@naver.com");
		couponRepository.save(testCoupon);
//		couponRepository.save(new Perso().setEmail("mail"));
	}

}
