package com.kakaohomework.demo;

import com.kakaopay.App;
import com.kakaopay.entity.Person;
import com.kakaopay.service.StringTo12LengthMapping;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class DemoApplicationTests {

	@Test
	public void contextLoads() throws Exception {

		Assert.assertEquals("daum", "daum");
	}

	@Test
	public void digestIntegrity() throws Exception{


		StringTo12LengthMapping a = new StringTo12LengthMapping("www@daum.net"); // 숫자 1이 들어가면 똑같은 값이 된다.
		String d1 = a.digest();

		StringTo12LengthMapping b = new StringTo12LengthMapping("www9@daum.net");
		String d2 = b.digest();
		Assert.assertNotEquals(d1 ,d2);
	}

	@Test
	public void digestLength() throws Exception{

		StringTo12LengthMapping a = new StringTo12LengthMapping("www@jlasiejfliasjefliasdfasdfasdfasdfasdfasdfasdfifj.com");
		System.out.println(a.digest());
		Assert.assertEquals(16, a.digest().length());
	}


}
