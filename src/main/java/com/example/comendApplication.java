package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class comendApplication {
	
	@Autowired
	ApplicationContext context;
	
	@Bean
	public CommandLineRunner runner() {
		return (args) -> {
			int count = context.getBeanDefinitionCount();
	        System.out.println("Beans的个数：" + count);
	        String[] names = context.getBeanDefinitionNames();
	        for (String name : names) {
	        		System.out.printf("%s -> %s\n", name, context.getBean(name));
	        }
		};
	}
	
	@Bean
		public String myBean(@Value("${name}") String names) {
			return names;
		}
	
//	@Component
//	public class MyBean {
//
//		@Value("${name}")
//		private String name;
//	}
}
