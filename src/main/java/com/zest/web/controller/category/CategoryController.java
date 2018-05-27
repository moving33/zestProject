package com.zest.web.controller.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// 카테고리 페이지 컨트롤러
@Controller
public class CategoryController {

	// 카테고리 페이지
	@RequestMapping(value = "/category", method=RequestMethod.GET)
	public ModelAndView viewMainPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("category/categoryPage");
		return modelAndView;
	}
}
