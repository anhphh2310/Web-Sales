package phhanh.tma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="phhanh.tma.*")
public class WebSalesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebSalesApplication.class, args);
	}

}
