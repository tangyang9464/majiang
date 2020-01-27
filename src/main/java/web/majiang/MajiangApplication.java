package web.majiang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"web.majiang.mapper"})
@SpringBootApplication
public class MajiangApplication {

	public static void main(String[] args) {
		SpringApplication.run(MajiangApplication.class, args);
	}

}
