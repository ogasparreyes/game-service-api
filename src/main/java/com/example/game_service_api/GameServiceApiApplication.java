package com.example.game_service_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GameServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameServiceApiApplication.class, args);
	}

}
