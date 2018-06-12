package com.zest.web.client.controller.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.ClientVO;
import com.zest.web.client.model.TalentTimeUtil;
import com.zest.web.client.model.TuTorVO;
import com.zest.web.client.model.Tutor_PropVO;
import com.zest.web.client.service.tutor.Tutor_PropSearchService;
import com.zest.web.client.service.tutor.Tutor_SearchService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
	
	//해당 튜터의 등록내용을 잠시 저장해두는 해쉬맵
	HashMap<Integer, TalentTimeUtil> saveTimeData;
	
	
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
    
    //튜터등록 페이지에서 시간 내용 db에처리하는 컨트롤러
    @RequestMapping(value="/tutorPage/talentPropTime")
    @ResponseBody
    @SuppressWarnings("unchecked")
    public String insertTimeData(@RequestBody Map<String, Object> timeMap,TalentTimeUtil talentTimeUtil,HttpSession session) {    	
    	//전달 내용을 변수에 저장
		HashMap<String, Object> zone1 =(HashMap<String, Object>) timeMap.get("zone1");
		HashMap<String, Object> zone2 =(HashMap<String, Object>) timeMap.get("zone2");
		HashMap<String, Object> zone3 =(HashMap<String, Object>) timeMap.get("zone3");
		
		//몇 개나 값이 저장되이었는지 확인
		int count = 1;
		//null 값 여부 확인 
		if(zone2.containsKey("zoneId")) {
			count ++;
		}
		if(zone3.containsKey("zoneId")) {
			count ++;
		}				
		// 간유틸클래스를 사용해서 해당 내용들을 담는다.
		for(int i=0;i<count;i++) {
			Map<String,TalentTimeUtil> m = new HashMap<>();
			if(i == 0) {
				talentTimeUtil.setCount(1);
				talentTimeUtil.setZone_id((String)zone1.get("zoneId"));
				talentTimeUtil.setMon((List<String>) zone1.get("mon"));
				talentTimeUtil.setTue((List<String>) zone1.get("tue"));
				talentTimeUtil.setWed((List<String>) zone1.get("wed"));
				talentTimeUtil.setTur((List<String>) zone1.get("tur"));
				talentTimeUtil.setFri((List<String>) zone1.get("fri"));
				talentTimeUtil.setSat((List<String>) zone1.get("sat"));
				talentTimeUtil.setSun((List<String>) zone1.get("sun"));				
				m.put("zone1", talentTimeUtil);
				talentTimeUtil.setTimeData(m);
			}
			if(i == 1) {
				talentTimeUtil.setCount(2);
				talentTimeUtil.setZone_id((String)zone2.get("zoneId"));
				talentTimeUtil.setMon((List<String>) zone2.get("mon"));
				talentTimeUtil.setTue((List<String>) zone2.get("tue"));
				talentTimeUtil.setWed((List<String>) zone2.get("wed"));
				talentTimeUtil.setTur((List<String>) zone2.get("tur"));
				talentTimeUtil.setFri((List<String>) zone2.get("fri"));
				talentTimeUtil.setSat((List<String>) zone2.get("sat"));
				talentTimeUtil.setSun((List<String>) zone2.get("sun"));
				m.put("zone2", talentTimeUtil);
				talentTimeUtil.setTimeData(m);
			}
			if(i == 2) {
				talentTimeUtil.setCount(3);
				talentTimeUtil.setZone_id((String)zone3.get("zoneId"));
				talentTimeUtil.setMon((List<String>) zone3.get("mon"));
				talentTimeUtil.setTue((List<String>) zone3.get("tue"));
				talentTimeUtil.setWed((List<String>) zone3.get("wed"));
				talentTimeUtil.setTur((List<String>) zone3.get("tur"));
				talentTimeUtil.setFri((List<String>) zone3.get("fri"));
				talentTimeUtil.setSat((List<String>) zone3.get("sat"));
				talentTimeUtil.setSun((List<String>) zone3.get("sun"));
				m.put("zone3", talentTimeUtil);
				talentTimeUtil.setTimeData(m);
			}
		}				
		//해당 내용을 공용으로 사용할 hashmap에 튜터의 넘버키 값으로 저장;
		TuTorVO t = (TuTorVO) session.getAttribute("tutorVO");
    	saveTimeData.put(t.getTt_no(), talentTimeUtil);
    	return "success";
    }
    
	public Tutor_PropSearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(Tutor_PropSearchService searchService) {
		this.searchService = searchService;
	}
    
    
    
}
