package com.zest.web.controller.main;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.aop.AopAdvice;
import com.zest.web.model.ClientVO;
import com.zest.web.model.LectureVO;
import com.zest.web.service.LectureService;

@Controller
public class MainPageController {

	private Logger logger = LoggerFactory.getLogger(MainPageController.class);

	@Autowired
	LectureService lectureService;

	// 카테고리 강의 리스트를 저장해 놓는 곳
	Map<String, List<LectureVO>> lectureVOlist = new HashMap<>();

	// 메인페이지
	@RequestMapping(value = "/main")
	public ModelAndView viewMainPage() {
		logger.info("..ing");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main/mainPage");

		// 해당 hashmap이 비었으면 정보를 넣는다.
		if (lectureVOlist.isEmpty()) {
			LectureVO lectureVO = new LectureVO();
			String[] categoryID = { "OTHER", "DESIGN", "LIFE", "MUSIC", "BEAUTY", "SPORTS", "BUSINESS", "LANGUAGE",
					"FOOD", "PROGRAM" };
			List<LectureVO> list = lectureService.getLectureList(lectureVO);
			
			for (int i = 0; i < categoryID.length; i++) {
				// lectureVO.setCategory_id(categoryID[i].toLowerCase());
				// List<LectureVO> list = lectureService.getLectureList(lectureVO);
				//List<LectureVO> list = lectureService.getLectureList(lectureVO);
				for (int j = 0; j < list.size(); j++) {
					if(list.get(j).getLecture_name() == categoryID[i]) {
						List<LectureVO> listSelect = new ArrayList<>();
						listSelect.add(list.get(j));
						lectureVOlist.put(categoryID[i], listSelect);
					}
				}
				//lectureVOlist.put(categoryID[i], list);
			}
		}
		
		return modelAndView;
	}

	// 카테고리 뷰 페이지
	@RequestMapping(value = "/main/{category}")
	@ResponseBody
	public List viewCategory(@PathVariable String category) {
		logger.info("..ing");

		if (!lectureVOlist.containsKey(category)) {
			List<String> categoryList = new ArrayList<String>();
			LectureVO lectureVO = new LectureVO();
			lectureVO.setCategory_id(category);
			List<LectureVO> list = lectureService.getLectureList(lectureVO);
			lectureVOlist.put(category, list);
			return list;
		} else {
			return lectureVOlist.get(category);

		}

	}
	
	//로그아웃처리
	@RequestMapping(value="/main/logout")
	public String logoutClient(HttpServletRequest request,HttpSession session ) {
		
		//해당 클라이언트를 가져와서
		logger.info(session.getId());
		ClientVO clientVO = (ClientVO) session.getAttribute("client");
		logger.info("로그아웃 기능 <로그아웃이 될 사용자의 정보 > : "+ clientVO.toString());
		if(clientVO != null) {
			session.removeAttribute("client");
			session.invalidate();
		}		
		//로그 아웃후 다시 메인 페이지로 이동
		return "redirect:/main";
		
	}

	public LectureService getLectureService() {
		return lectureService;
	}

	public void setLectureService(LectureService lectureService) {
		this.lectureService = lectureService;
	}

}
