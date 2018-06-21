package com.zest.web.client.controller.main;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.CategoryPageVO;
import com.zest.web.client.model.ClientVO;
import com.zest.web.client.model.LectureVO;
import com.zest.web.client.model.Paging;
import com.zest.web.client.service.LectureService;
import com.zest.web.client.service.main.MainPageGetCategoryService;

@Controller
public class MainPageController {

	private Logger logger = LoggerFactory.getLogger(MainPageController.class);

	@Autowired
	LectureService lectureService;
		
	@Autowired
	MainPageGetCategoryService mainPageGetCategoryService;
	
	@Autowired
	Paging pagind;

	// 카테고리 강의 리스트를 저장해 놓는 곳
	Map<String, List<LectureVO>> lectureVOlist = new HashMap<>();

	// 메인페이지
	@RequestMapping(value = "/main")
	public ModelAndView viewMainPage(@RequestParam(required = false) String search_type, 
			@RequestParam(required = false) String search_text) {
		logger.info("..ing (메인 페이지 컨트롤러)");
		
		ModelAndView modelAndView = new ModelAndView();
	
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
		
		
		// --------------------- 메인페이지 인기수업 작업 ------------------------
		System.out.println("메인페이지 인기수업 시작");
		
		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";
		
		// service로 넘겨줄 map객체 생성
		Map<String, Object> map = new HashMap<>();
		map.put("search_type", search_type);
		map.put("search_text", search_text);
		
		// 메인 페이지 인기수업 리스트를 받아옴
		System.out.println("메인페이지 인기수업 리스트 받아오기 시작");
		List<CategoryPageVO> list = mainPageGetCategoryService.mainPageGetHotCategory(map);
		System.out.println("메인페이지 인기수업 리스트 받아옴");
		
		// ------------------- 이미지 작업 ----------------------------


		for (int j = 0; j < list.size(); j++) {
			System.out.println(list.size());
			System.out.println("메인페이지 인기수업 이미지 작업");
			File dirFile = new File(list.get(j).getTc_image_path()); // 이미지 패키지 경로 c:\zest\talent\MUSIC\3
			System.out.println(dirFile);

			File[] files = dirFile.listFiles(); // 파일 담기

			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					if (i == 0) {
						String tempPath = files[i].getParent(); // c:\zest\talent\BEAUTY\1
						String tempFileName = files[i].getName(); // img0.jpg
						String subPath = tempPath.substring(8); // talent\BEAUTY\1

						System.out.println("sub Path : " + subPath);
						System.out.println("tempPtah 값 : " + tempPath);
						System.out.println("tempFileName 값: " + tempFileName);

						list.get(j).setTc_image_path("/LocalImage/" + subPath + "/" + tempFileName);

						break;
					}
				}
			}
		}

				// ------------------- 이미지 작업 끝 ----------------------------
		
		modelAndView.addObject("list", list);
		modelAndView.setViewName("main/mainPage");
		return modelAndView;
	}

	// 카테고리 뷰 페이지
	@RequestMapping(value = "/main/{category}")
	@ResponseBody
	public List viewCategory(@PathVariable String category) {
		logger.info("..ing");

		if (!lectureVOlist.containsKey(category)) {
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
			//마지막 로그인 업데이트 로그아웃시 할 의미가 없어서 로그인으로 옮김
			//clientUpdateService.clientLastLogin(clientVO);
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
