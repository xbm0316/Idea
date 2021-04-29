package cn.gdpi.bookmall;


import cn.gdpi.bookmall.util.JwtTokenUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class BookMallApplicationTests {


	@Resource
	private JwtTokenUtil jwtTokenUtil;

  @Test
  void contextLoads() throws ParseException {

	  SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmm");
	  String dateStr=format.format(new Date());
	  String phone="13822968044";
	  String orderId= phone.substring(8)+dateStr;
	  System.out.println(orderId);
	}


}
