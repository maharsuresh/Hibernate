package com.athena.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HibernateJpaSpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HibernateJpaSpringbootApplication.class, args);
		for (String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
