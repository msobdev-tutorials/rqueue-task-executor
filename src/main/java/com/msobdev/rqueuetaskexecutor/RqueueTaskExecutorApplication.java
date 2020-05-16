package com.msobdev.rqueuetaskexecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableRedisRepositories
@EnableWebMvc
@SpringBootApplication
public class RqueueTaskExecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RqueueTaskExecutorApplication.class, args);
	}

}
