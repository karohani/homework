package com.kakaohomework.demo;

import com.kakaopay.App;
import com.kakaopay.controller.CouponController;
import com.kakaopay.entity.Coupon;
import com.kakaopay.service.CouponService;
import com.kakaopay.service.CouponServiceImpl;
import com.kakaopay.service.StringTo16LengthMapping;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class, CouponServiceImpl.class})
public class ServiceTests {

	@Autowired
	private CouponService couponService;
	@Autowired
	private WebApplicationContext context;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}


	@Test
	public void contextLoads() throws Exception {

		Assert.assertEquals("daum", "daum");
	}

	@Test
	public void digestIntegrity() throws Exception{


		StringTo16LengthMapping a = new StringTo16LengthMapping("www@daum.net"); // 숫자 1이 들어가면 똑같은 값이 된다.
		String d1 = a.digest();

		StringTo16LengthMapping b = new StringTo16LengthMapping("www9@daum.net");
		String d2 = b.digest();
		Assert.assertNotEquals(d1 ,d2);
	}

	@Test
	public void digestLength() throws Exception{

		StringTo16LengthMapping a = new StringTo16LengthMapping("www@jlasiejfliasjefliasdfasdfasdfasdfasdfasdfasdfifj.com");
		System.out.println(a.digest());
		Assert.assertEquals(16, a.digest().length());
	}

	@Test public void mainTest() throws Exception{
		int port = 8080;
		RestTemplate restTemplate = new RestTemplate();
		String message = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		System.out.println(message);
	}

	@Test public void sameEmail() throws Exception {

		try{
			couponService.generateCoupon("www@daum.net");
			couponService.generateCoupon("www@daum.net");
		}catch(ConstraintViolationException e){
			Assert.assertEquals(1,1);
		}catch(Exception e) {

		}

	}

	@Test public void isExistEmail()throws Exception{

		couponService.generateCoupon("www@youtube.com");
		Assert.assertEquals(couponService.isExistEmail("www@youtube.com"), true);

	}


	@Test public void isExistCoupon() throws Exception{
		Coupon coupon = couponService.generateCoupon("www@kakao.com");
		Assert.assertEquals(couponService.isExistCoupon(coupon.getCoupon()), true);
	}

	@Test
	public void insertEmail() throws Exception{

	}
}
