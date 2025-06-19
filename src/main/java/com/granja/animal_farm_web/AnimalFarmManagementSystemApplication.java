package com.granja.animal_farm_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.animal_farm_web")
public class AnimalFarmManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnimalFarmManagementSystemApplication.class, args);
	}

}
