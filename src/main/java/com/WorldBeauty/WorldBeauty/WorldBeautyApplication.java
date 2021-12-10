package com.WorldBeauty.WorldBeauty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages ={"com.WorldBeauty.models"})
public class WorldBeautyApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorldBeautyApplication.class, args);
		//System.out.print(new BCryptPasswordEncoder().encode("123"));
	}

}
