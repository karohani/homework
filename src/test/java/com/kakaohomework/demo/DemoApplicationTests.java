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


		StringTo12LengthMapping a = new StringTo12LengthMapping("www@gmail.com");
		String d1 = a.digest();

		StringTo12LengthMapping b = new StringTo12LengthMapping("www@gmail.com");
		String d2 = b.digest();
		Assert.assertEquals(d1 ,d2);
	}

	@Test
	public void digestLength() throws Exception{

		StringTo12LengthMapping a = new StringTo12LengthMapping("www@gmail.com");

		Assert.assertEquals(12, a.digest().length());
	}


}
