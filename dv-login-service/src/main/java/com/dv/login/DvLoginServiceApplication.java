package com.dv.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.dv.login"}, exclude= {RedisRepositoriesAutoConfiguration.class})
public class DvLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvLoginServiceApplication.class, args);
	}

}
