package com.deniz.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.deniz.domain.Student;

@Configuration
public class RepositoryConfiguration  implements RepositoryRestConfigurer{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	
		config.exposeIdsFor(Student.class);
		config.setPageParamName("p")
		       .setLimitParamName("l")
		       .setSortParamName("q");
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
	}

	
	
	
}
