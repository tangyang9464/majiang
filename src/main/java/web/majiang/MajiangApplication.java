package web.majiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"web.majiang.mapper"})
@SpringBootApplication
public class MajiangApplication {

	public static void main(String[] args) {
		SpringApplication.run(MajiangApplication.class, args);
	}

}
