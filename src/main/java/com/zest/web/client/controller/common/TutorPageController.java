package com.zest.web.client.controller.common;

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.ClientVO;
import com.zest.web.client.model.TalentInfo;
import com.zest.web.client.model.TalentTimeUtil;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;
import com.zest.web.client.model.TuTorVO;
import com.zest.web.client.model.Tutor_PropVO;
import com.zest.web.client.service.talent.TalentInsertService;
import com.zest.web.client.service.tutor.Tutor_PropSearchService;
import com.zest.web.client.service.tutor.Tutor_SearchService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TutorPageController {

	// 상태 검색
	@Autowired
	private Tutor_PropSearchService searchService;
	// 튜터 검색 서비스
	@Autowired
	private Tutor_SearchService tutor_SearchService;
	// 강의 등록 서비스
	@Autowired
	private TalentInsertService talentInsertService;

	// 해당 튜터의 등록내용을 잠시 저장해두는 해쉬맵
	Map<Integer, TalentTimeUtil> saveTimeData = new HashMap<>();

	@RequestMapping(value = "/tutorPage")
	public ModelAndView viewTutorPageController(ModelAndView modelAndView, HttpSession session, Tutor_PropVO vo) {

		modelAndView.setViewName("common/myPage");
		// 튜터페이지인지 확인시켜주는 녀석
		modelAndView.addObject("pageType", "tutor");

		ClientVO clientVO = (ClientVO) session.getAttribute("client");
		vo.setTp_email(clientVO.getCl_email());
		// 해당 사용자 튜터 신청 내역 조회

		vo = searchService.getTutor_propStatus(vo);
		if (vo == null) {
			modelAndView.setViewName("common/myPage");
			// modelAndView.setViewName("redirect:clientPage");
			modelAndView.addObject("pageType", null);
			// 처리를 튜터 데이터를 넣어준다.
			modelAndView.addObject("tutorData", "fail");
			return modelAndView;
		}
		// 튜터 신청내역 모델에 저장
		modelAndView.addObject("tt_prop", vo);
		return modelAndView;
	}

	// 튜터 페이지 - 강의 등록 페이지
	@RequestMapping(value = "/tutorPage/regiTalent")
	@ResponseBody
	public String viewTalentRegiPage(Model model, HttpSession session) {

		ClientVO client = (ClientVO) session.getAttribute("client");
		// 이메일 아이디 가져오기
		String clientEmailId = client.getCl_email();
		TuTorVO tuTorVO = tutor_SearchService.getTutorForClientEmail(clientEmailId);
		// 해당 튜터가 없을시
		if (tuTorVO == null) {
			return "fail";
		}
		System.out.println(tuTorVO.toString());
		// 해당 튜터 객체 세션에 추가
		session.setAttribute("tutorVO", tuTorVO);
		// 해당 내용 모델에 추가
		model.addAttribute("tutorVO", tuTorVO);
		return "success";

	}

	// 튜터 등록 페이지 보여주기
	@RequestMapping(value = "/tutorPage/talentProp")
	public String viewOpenTalentProp() {
		return "/common/talentOpenPage";
	}

	// 튜터등록 페이지에서 시간 내용 db에처리하는 컨트롤러 not Oneday
	@RequestMapping(value = "/tutorPage/talentPropTime")
	@ResponseBody
	@SuppressWarnings("unchecked")
	public String insertTimeData(@RequestBody Map<String, Object> timeMap, TalentTimeUtil rootTalentTimeUtil,
			HttpSession session) {
		// 전달 내용을 변수에 저장
		HashMap<String, Object> zone1 = (HashMap<String, Object>) timeMap.get("zone1");
		HashMap<String, Object> zone2 = (HashMap<String, Object>) timeMap.get("zone2");
		HashMap<String, Object> zone3 = (HashMap<String, Object>) timeMap.get("zone3");

		System.out.println((String) zone1.get("zoneId"));
		List<String> a = (ArrayList<String>) zone1.get("mon");
		System.out.println(a.get(0));

		// 몇 개나 값이 저장되이었는지 확인
		int count = 1;
		// null 값 여부 확인
		if (zone2.containsKey("zoneId")) {
			count++;
		}
		if (zone3.containsKey("zoneId")) {
			count++;
		}
		// 간유틸클래스를 사용해서 해당 내용들을 담는다.
		rootTalentTimeUtil.setCount(count);
		Map<String, TalentTimeUtil> m = new HashMap<>();

		for (int i = 0; i < count; i++) {
			TalentTimeUtil talentTimeUtil = new TalentTimeUtil();
			if (i == 0) {
				talentTimeUtil.setZone_id((String) zone1.get("zoneId"));
				if (!zone1.get("mon").equals("")) {
					talentTimeUtil.setMon((ArrayList<String>) zone1.get("mon"));
				}
				if (!zone1.get("tue").equals("")) {
					talentTimeUtil.setTue((ArrayList<String>) zone1.get("tue"));
				}
				if (!zone1.get("wed").equals("")) {
					talentTimeUtil.setWed((ArrayList<String>) zone1.get("wed"));
				}
				if (!zone1.get("tur").equals("")) {
					talentTimeUtil.setTur((ArrayList<String>) zone1.get("tur"));
				}
				if (!zone1.get("fri").equals("")) {
					talentTimeUtil.setFri((ArrayList<String>) zone1.get("fri"));
				}
				if (!zone1.get("sat").equals("")) {
					talentTimeUtil.setSat((ArrayList<String>) zone1.get("sat"));
				}
				if (!zone1.get("sun").equals("")) {
					talentTimeUtil.setSun((ArrayList<String>) zone1.get("sun"));
				}
				m.put("zone1", talentTimeUtil);
				rootTalentTimeUtil.setTimeData(m);
			}
			if (i == 1) {
				talentTimeUtil.setZone_id((String) zone2.get("zoneId"));
				if (!zone2.get("mon").equals("")) {
					talentTimeUtil.setMon((ArrayList<String>) zone2.get("mon"));
				}
				if (!zone2.get("tue").equals("")) {
					talentTimeUtil.setTue((ArrayList<String>) zone2.get("tue"));
				}
				if (!zone2.get("wed").equals("")) {
					talentTimeUtil.setWed((ArrayList<String>) zone2.get("wed"));
				}
				if (!zone2.get("tur").equals("")) {
					talentTimeUtil.setTur((ArrayList<String>) zone2.get("tur"));
				}
				if (!zone2.get("fri").equals("")) {
					talentTimeUtil.setFri((ArrayList<String>) zone2.get("fri"));
				}
				if (!zone2.get("sat").equals("")) {
					talentTimeUtil.setSat((ArrayList<String>) zone2.get("sat"));
				}
				if (!zone2.get("sun").equals("")) {
					talentTimeUtil.setSun((ArrayList<String>) zone2.get("sun"));
				}
				m.put("zone2", talentTimeUtil);
				rootTalentTimeUtil.setTimeData(m);
			}
			if (i == 2) {
				talentTimeUtil.setZone_id((String) zone3.get("zoneId"));
				if (!zone3.get("mon").equals("")) {
					talentTimeUtil.setMon((ArrayList<String>) zone3.get("mon"));
				}
				if (!zone3.get("tue").equals("")) {
					talentTimeUtil.setTue((ArrayList<String>) zone3.get("tue"));
				}
				if (!zone3.get("wed").equals("")) {
					talentTimeUtil.setWed((ArrayList<String>) zone3.get("wed"));
				}
				if (!zone3.get("tur").equals("")) {
					talentTimeUtil.setTur((ArrayList<String>) zone3.get("tur"));
				}
				if (!zone3.get("fri").equals("")) {
					talentTimeUtil.setFri((ArrayList<String>) zone3.get("fri"));
				}
				if (!zone3.get("sat").equals("")) {
					talentTimeUtil.setSat((ArrayList<String>) zone3.get("sat"));
				}
				if (!zone3.get("sun").equals("")) {
					talentTimeUtil.setSun((ArrayList<String>) zone3.get("sun"));
				}
				m.put("zone3", talentTimeUtil);
				rootTalentTimeUtil.setTimeData(m);
			}
		}
		// 세션에 저장되어 있는 튜터 정보 가져오기
		TuTorVO vo = (TuTorVO) session.getAttribute("tutorVO");
		System.out.println(vo.toString());
		// 해당 내용을 공용으로 사용할 hashmap에 튜터의 넘버키 값으로 저장;
		saveTimeData.put(vo.getTt_no(), rootTalentTimeUtil);

		System.out.println(rootTalentTimeUtil.toString());
		// 내용 추출해보기
		return "success";
	}

	// 튜터등록 페이지 에서 시간내용 db에서 처리 하는 컨트롤러 Onday
	@RequestMapping(value = "/tutorPage/talentPropTime2")
	@SuppressWarnings({ "unused", "unchecked" })
	public String insertTimeData2(@RequestBody Map<String, Object> timeMap) {
		HashMap<String, Object> zone1 = (HashMap<String, Object>) timeMap.get("zone1");
		HashMap<String, Object> zone2 = (HashMap<String, Object>) timeMap.get("zone2");
		HashMap<String, Object> zone3 = (HashMap<String, Object>) timeMap.get("zone3");

		// 몇 개나 값이 저장되이었는지 확인
		int count = 1;
		// null 값 여부 확인
		if (zone2.containsKey("zoneid")) {
			count++;
		}
		if (zone3.containsKey("zoneid")) {
			count++;
		}
		
		
		

		return "success";
	}

	// 튜터등록 버튼 클릭시 처리해주는 녀석
	@RequestMapping(value = "/tutorPage/talentRegi", method = RequestMethod.POST)
	public String regiTalent(TalentVO talentVO, Talent_contentVO contentVO, HttpSession session,
			TalentInfo talentInfo) {

		// hash map 에 저장되어있는 시간 가져오기
		TuTorVO vo = (TuTorVO) session.getAttribute("tutorVO");
		TalentTimeUtil timeUtil = saveTimeData.get(vo.getTt_no());
		// 내용 등록 서비스
		talentInsertService.insertTalent(talentVO, contentVO, talentInfo, vo, timeUtil);
		return null;
	}

	public Tutor_PropSearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(Tutor_PropSearchService searchService) {
		this.searchService = searchService;
	}

}
