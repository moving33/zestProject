package com.zest.web.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//클라이언트 페이지 , 마이페이지
@Controller
public class ClientPageController {
	
	private Logger logger = LoggerFactory.getLogger(ClientPageController.class);
	
	@RequestMapping(value="/clientPage")
	public ModelAndView viewClientPage(ModelAndView modelAndView) {
		logger.info("...ing");
		modelAndView.setViewName("common/myPage");
		return modelAndView;
	}

}
