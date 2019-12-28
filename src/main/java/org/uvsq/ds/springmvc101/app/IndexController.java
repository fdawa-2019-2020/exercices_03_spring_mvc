package org.uvsq.ds.springmvc101.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	private Logger logger = LoggerFactory.getLogger(IndexController.class);

	private final String message = "Celui qui déplace la montagne, c’est celui qui commence à enlever les petites pierres";

	public IndexController() {
		logger.info("IndexController Creation");
	}

	@RequestMapping({ "/", "/index" })
	public ModelAndView index() {
		return new ModelAndView("index", "welcome_message", message);
	}

}
