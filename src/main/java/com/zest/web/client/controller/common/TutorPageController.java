package com.zest.web.client.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.ClientVO;
import com.zest.web.client.model.TuTorVO;
import com.zest.web.client.model.Tutor_PropVO;
import com.zest.web.client.service.tutor.Tutor_PropSearchService;
import com.zest.web.client.service.tutor.Tutor_SearchService;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("tutorVO")
public class TutorPageController {

	//상태 검색
	@Autowired
	private Tutor_PropSearchService searchService;
	//튜터 검색 서비스
	@Autowired
	private Tutor_SearchService tutor_SearchService;
	
    @RequestMapping(value = "/tutorPage")
    public ModelAndView viewTutorPageController(ModelAndView modelAndView,HttpSession session,Tutor_PropVO vo) {

        modelAndView.setViewName("common/myPage");
        //튜터페이지인지 확인시켜주는 녀석
        modelAndView.addObject("pageType","tutor");
        
        ClientVO clientVO = (ClientVO) session.getAttribute("client");
        vo.setTp_email(clientVO.getCl_email());
        //해당 사용자 튜터 신청 내역 조회
        
        vo = searchService.getTutor_propStatus(vo);
        if(vo == null) {
        	modelAndView.setViewName("common/myPage");
        	//modelAndView.setViewName("redirect:clientPage");
        	modelAndView.addObject("pageType", null);
        	//처리를 튜터 데이터를 넣어준다.
        	modelAndView.addObject("tutorData","fail");
        	return modelAndView;
        }
        //튜터 신청내역 모델에 저장 
        modelAndView.addObject("tt_prop", vo);
        return modelAndView;
    }
    
    //튜터 페이지 - 강의 등록 페이지
    @RequestMapping(value="/tutorPage/regiTalent")
    @ResponseBody
    public String viewTalentRegiPage(Model model,HttpSession session) {
    	
    	ClientVO client = (ClientVO) session.getAttribute("client");
    	//이메일 아이디 가져오기 
    	String clientEmailId = client.getCl_email();
    	TuTorVO tuTorVO = tutor_SearchService.getTutorForClientEmail(clientEmailId);
    	//해당 튜터가 없을시 
    	if(tuTorVO == null) {
    		return "fail";
    	}
    	System.out.println(tuTorVO.toString());
    	//해당 내용 모델에 추가 
    	model.addAttribute("tutorVO",tuTorVO);
    	return "success";
    	
    }

    
    //튜터 등록 페이지 보여주기
    @RequestMapping(value="/tutorPage/talentProp")
    public String viewOpenTalentProp() {
    	return "/common/talentOpenPage";
    }
    
	public Tutor_PropSearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(Tutor_PropSearchService searchService) {
		this.searchService = searchService;
	}
    
    
    
}
