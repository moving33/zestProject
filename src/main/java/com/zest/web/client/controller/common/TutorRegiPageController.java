package com.zest.web.client.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//튜터 등록 페이지
@Controller
public class TutorRegiPageController {
	
	private Logger logger = LoggerFactory.getLogger(TutorRegiPageController.class);
	
	@RequestMapping(value="/tutorRegiPage")
	public ModelAndView viewTutorRegiPage(ModelAndView modelAndView) {
		logger.info("...ing");
		
		modelAndView.setViewName("common/tutorRegistPage");		
		return modelAndView;
	}
}
