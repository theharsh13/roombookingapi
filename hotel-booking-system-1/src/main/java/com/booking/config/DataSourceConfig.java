package com.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataSourceConfig {
	
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

}
