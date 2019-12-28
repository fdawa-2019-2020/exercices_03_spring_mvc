package org.uvsq.ds.springmvc101.app;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping({ "/index-mav" })
	public ModelAndView indexModelAndView() {
		Map<String, String> model = new HashMap<>();
		model.put("welcome_message", message);
		return new ModelAndView("index", model);
	}
	
	@RequestMapping({"/index-str"})
	public String indexString(Model model) {
	  model.addAttribute("welcome_message", message);
	  return "index";
	}
}
