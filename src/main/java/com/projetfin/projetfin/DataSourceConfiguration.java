package com.projetfin.projetfin;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfiguration {


	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.username(System.getenv("school_db_username"));
		dataSourceBuilder.password(System.getenv("school_db_password"));
		dataSourceBuilder.url(System.getenv("school_db_url"));

		return dataSourceBuilder.build();
	}

}
