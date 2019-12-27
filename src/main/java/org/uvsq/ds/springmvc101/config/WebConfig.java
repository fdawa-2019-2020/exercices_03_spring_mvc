package org.uvsq.ds.springmvc101.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
public class WebConfig {
	
	private static Logger logger = LoggerFactory.getLogger(WebConfig.class); 
	
	public WebConfig() {
		logger.info("WebConfig Creation");
	}

}