package com.zest.web.client.controller.common;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.ReviewVO;
import com.zest.web.client.service.client.ClassDetailService;
import com.zest.web.client.service.client.ReviewService;

@Controller
public class ReviewPageController {
	@Autowired
	ReviewService reviewService;
	
	//튜터 정보 검색 해 주기
	@Autowired
	ClassDetailService detailService;
	

	@RequestMapping(value="/reviewPage")
	public ModelAndView viewReviewPage(ModelAndView modelAndView) {
		modelAndView.setViewName("common/reviewPage");
		return modelAndView;
		
	}

	@RequestMapping(value="/reviewPage/{talent_no}", method = RequestMethod.POST)
	public ModelAndView reviewRegi(@PathVariable int talent_no, HttpSession session, ModelAndView modelAndView, ReviewVO vo, ClassDetail_TutorVO Tvo) {
		Tvo = detailService.tutorCall(talent_no);
		//vo = reviewService.ReviewInsert(vo);
		
		System.out.println("Tvo Tvo : " + Tvo.toString());
		modelAndView.addObject("Review", Tvo);
		modelAndView.setViewName("common/reviewPage");
		return modelAndView;
	}

	public ReviewService getReviewService() {
		return reviewService;
	}

	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	
	
	
}
