package com.dv.mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.dv.mgmt"}, exclude= {RedisRepositoriesAutoConfiguration.class})
public class DvMgmtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvMgmtServiceApplication.class, args);
	}

}
