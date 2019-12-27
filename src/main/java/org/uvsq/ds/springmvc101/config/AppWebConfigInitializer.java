package org.uvsq.ds.springmvc101.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppWebConfigInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	private static Logger logger = LoggerFactory.getLogger(AppWebConfigInitializer.class);
	

	public AppWebConfigInitializer() {
		logger.info("AppWebConfigInitializer Creation");
	}

	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}