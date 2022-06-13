package com.ty.foodOrder;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages= "com.ty.foodOrder")
public class MyConfig {
	@Bean(value="entity")
	public EntityManagerFactory getEntityMangerFactory() {
		return Persistence.createEntityManagerFactory("vikas");
	}
}
