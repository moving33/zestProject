package com.zest.web.client.controller.category;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.CategoryPageVO;
import com.zest.web.client.model.Paging;
import com.zest.web.client.service.CategoryPageService;

// 카테고리 페이지 컨트롤러
@Controller
public class CategoryController {

	@Autowired
	CategoryPageService categoryPageService;
	
	@Autowired
	Paging paging;
	
	
	// 카테고리 페이지 리스트 반환
	@RequestMapping(value = "/category/{category}", method=RequestMethod.GET)
	public ModelAndView viewMainPage(ModelAndView modelAndView, @PathVariable String category, @RequestParam(required = false) String pageNum,
			@RequestParam(required = false) String search_type, @RequestParam(required = false) String search_text) {
		
		System.out.println("카테고리 컨트롤러 - 받아온 카테고리 종류: " + category);
		
		// VO에 받아온 카테고리를 입력
		CategoryPageVO vo = new CategoryPageVO();
		/*vo.setTalent_category_id(category);*/
		vo.setTalent_category_id(category); // View에서 받아온 URL 입력 
		
		// ----------------------------- 시작 -------------------------
		
		if (pageNum == null || pageNum == "")
			pageNum = "1";

		// 현재페이지
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
		int pageSize = 15; // 페이지당 보여줄 글
		int pageBlockSize = 5; // 페이지 블록의 사이즈

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";

		// service로 넘겨줄 map객체 생성
		Map<String, Object> map = new HashMap<>();
		map.put("search_type", search_type);
		map.put("search_text", search_text);

		// 검색설정확인
		if (search_type == null)
			search_type = "";
		if (search_text == null)
			search_text = "";
		
		// 총 글 수 가져오기
		int count = categoryPageService.getCategoryPageListCount(category);
		System.out.println(count);
		
		// 페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		map.put("startRow", paging.getWriting_Start());
		map.put("endRow", paging.getWriting_End());
		map.put("talent_category_id", vo.getTalent_category_id());
		
		//------------------------  끝 -----------------------------
		
		
		
		// 카테고리 페이지 리스트를 받아옴
		List<CategoryPageVO> categoryPageList = categoryPageService.getCategoryPageList(map);
		System.out.println("받아온 카테고리 리스트:" + categoryPageList.toString());
		
		
		// ------------------- 이미지 작업 ----------------------------
		
		Map<String, Object> model = new HashMap<>();
		if(!categoryPageList.get(0).getTc_image_path().isEmpty()) {
			
		File dirFile = new File(categoryPageList.get(0).getTc_image_path()); // 파일경로 c:\zest\talent\MUSIC\3
		
	    System.out.println(dirFile);
	    File[] files = dirFile.listFiles(); //파일 담기
	    System.out.println("File :" + files.toString());

	    for (int i = 0; i < files.length; i++) {
	         if (files[i].isFile()) {
	        	 if(i == 0) {
	            String tempPath = files[i].getParent();
	            String tempFileName = files[i].getName();
	            int lastDot = tempFileName.lastIndexOf('.');
	            
	            String subPath = tempPath.substring(8);
	            System.out.println("sub Path : " + subPath);

	            System.out.println("tempPtah 값 : " + tempPath);
	            System.out.println("tempFileName 값: " + tempFileName);

	            model.put("image" + i, "/LocalImage/" + subPath + "/" + tempFileName);
	            break;
	        	 }

	         }
	      }
		}
		// ------------------- 이미지 작업 끝 ----------------------------
		
		
		// View에 넘기는 데이터
		model.put("count", count);
		model.put("categoryPageList", categoryPageList);
		model.put("pageNum", pageNum);
		model.put("search_text", search_text);
		model.put("search_type", search_type);
		model.put("bp", paging);
		
		modelAndView.addAllObjects(model);
		modelAndView.setViewName("category/categoryPage");
		return modelAndView;
	}
}
