package com.zest.web.client.controller.category;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.CategoryPageVO;
import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.ReviewVO;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.service.client.ClassDetailService;

@Controller
public class ClassDetailController {

	@Autowired
	ClassDetailService classDetailService;

	// 상세수업페이지
	/*@RequestMapping(value = "/classDetail")
	public ModelAndView viewMainPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("category/classDetail");
		System.out.println("11111111111111111");
		return modelAndView;
	}*/

	@RequestMapping(value = "/category/{category}/{talent_no}")
	public ModelAndView classDetail(@PathVariable int talent_no, ModelAndView modelAndView, ClassDetailVO vo,
			TalentVO Tvo, ClassDetail_TutorVO Cvo) {
		System.out.println("2222222222222");
		System.out.println(talent_no);
		vo = classDetailService.contentCall(talent_no);
		Tvo = classDetailService.talentCall(talent_no);
		Cvo = classDetailService.tutorCall(talent_no);
		
	
		
		// View에서 사용할 이미지
		
		Map<String, Object> model = new HashMap<>(); //model 저장할 MAP

		File dirFile = new File(vo.getTc_image_path()); // 파일경로 c:\zest\talent\MUSIC\3
		File[] files = dirFile.listFiles(); //파일 담기
		List<String> images = new ArrayList<String>();
		
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				String tempPath = files[i].getParent();
				String tempFileName = files[i].getName();
				
				String subPath = tempPath.substring(8);
				System.out.println("sub Path : " + subPath);

				System.out.println("tempPtah 값 : " + tempPath);
				System.out.println("tempFileName 값: " + tempFileName);
				
				String imagePath = "/LocalImage/" + subPath + "/" + tempFileName;
				
				//model.put("image" + i, "/LocalImage/" + subPath + "/" + tempFileName);
				
				images.add(imagePath);
						
				
			}
		}

		
		// 커리큘럼 회차 나누기
		String date = vo.getTc_curriculum(); //커리큘럼 뽑아오기
		System.out.println("커리큘럼 : " + date);
		String delimiter = "!@#%"; 
		
		String[] curri_Arr = date.split(delimiter);
		
		modelAndView.addObject("cur", curri_Arr);
		
		
		// 지워도 되는것
		for(int i=0; i<curri_Arr.length; i++) {
			System.out.println(i+ " = " + curri_Arr[i]);
			model.put("curri" + i , i+1 + "회차" + curri_Arr[i]);

		}
		
		// 프로필 이미지 사진
		

		File pro = new File(Cvo.getTt_im_path()); 
		File[] profile = pro.listFiles();
		
		for (int i = 0; i < profile.length; i++) {
			if (profile[i].isFile()) {
		
		String proimg = profile[i].getParent();
		String proname = profile[i].getName();
		
		String subPro = proimg.substring(8);
		
		//System.out.println("서브프로로로로로로로로로 = " + subPro);
		//System.out.println("프로네임임  : " + proname);
		
		model.put("pro" + i, "/LocalImage/" + subPro + "/" + proname);
			}
			
		}
		modelAndView.addObject("imgPath", images);
		
		
		// 리뷰 보여주기
		List<ReviewVO> Rvo = classDetailService.reviewCall(talent_no);
		model.put("review", Rvo);

		
		//리뷰 평균 값
		ReviewVO avgReview = classDetailService.reviewValue(talent_no);
		model.put("avg", avgReview);


		modelAndView.addObject("detail", vo);
		modelAndView.addObject("talent", Tvo);
		modelAndView.addObject("tutor", Cvo);
		modelAndView.addAllObjects(model);

		
		modelAndView.setViewName("category/classDetail");
		return modelAndView;
	}

}
