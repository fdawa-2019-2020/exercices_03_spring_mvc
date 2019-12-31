package org.uvsq.ds.springmvc101.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.uvsq.ds.springmvc101.ScanPackageRoot;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ScanPackageRoot.class)
public class WebConfig implements WebMvcConfigurer {
	
	private static Logger logger = LoggerFactory.getLogger(WebConfig.class); 
	
	public WebConfig() {
		logger.info("WebConfig Creation");
	}
	
	@Bean
	public ViewResolver jspViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	       registry
	          .addResourceHandler("/resources/**")
	          .addResourceLocations("/resources/");	
	}

}