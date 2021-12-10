package com.WorldBeauty.WorldBeauty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages ={"com.WorldBeauty.models"})
public class WorldBeautyApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorldBeautyApplication.class, args);
	}

}
