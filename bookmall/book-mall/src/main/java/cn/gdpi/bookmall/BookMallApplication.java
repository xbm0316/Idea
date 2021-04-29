package cn.gdpi.bookmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lihaotao
 */
@EnableTransactionManagement
@MapperScan("cn.gdpi.bookmall.mapper")
@SpringBootApplication
public class BookMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMallApplication.class, args);
	}

}