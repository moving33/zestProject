package com.zest.web.client.controller.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.ClientVO;
import com.zest.web.client.model.TalentInfo;
import com.zest.web.client.model.TalentTimeUtil;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.TalentOneDayTimeVO;
import com.zest.web.client.model.Talent_contentVO;
import com.zest.web.client.model.TuTorVO;
import com.zest.web.client.model.Tutor_PropVO;
import com.zest.web.client.service.talent.TalentInsertService;
import com.zest.web.client.service.talent.time.TalentTimeInsertService;
import com.zest.web.client.service.tutor.Tutor_PropSearchService;
import com.zest.web.client.service.tutor.Tutor_SearchService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

	// oneday 시간 등록 서비스
	@Autowired
	private TalentTimeInsertService talentTimeInsertService;

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

		int count = (int) timeMap.get("count");
		System.out.println(count);
		HashMap<String, Object> zone1 = null;
		HashMap<String, Object> zone2 = null;
		HashMap<String, Object> zone3 = null;

		if (count == 1) {
			zone1 = (HashMap<String, Object>) timeMap.get("zone1");
		} else if (count == 2) {
			zone1 = (HashMap<String, Object>) timeMap.get("zone1");
			zone2 = (HashMap<String, Object>) timeMap.get("zone2");
		} else if (count == 3) {
			zone1 = (HashMap<String, Object>) timeMap.get("zone1");
			zone2 = (HashMap<String, Object>) timeMap.get("zone2");
			zone3 = (HashMap<String, Object>) timeMap.get("zone3");
		}

		/*
		 * // 전달 내용을 변수에 저장 HashMap<String, Object> zone1 = (HashMap<String, Object>)
		 * timeMap.get("zone1"); HashMap<String, Object> zone2 = (HashMap<String,
		 * Object>) timeMap.get("zone2"); HashMap<String, Object> zone3 =
		 * (HashMap<String, Object>) timeMap.get("zone3");
		 */

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
	@ResponseBody
	public String insertTimeData2(@RequestBody Map<String, Object> timeMap,HttpSession session) {
		HashMap<String, Object> zone1 = null;
		HashMap<String, Object> zone2 = null;
		HashMap<String, Object> zone3 = null;
		// 몇 개나 값이 저장되이었는지 확인
		int count = (Integer)timeMap.get("count");
		System.out.println("원데이 항목 저장된 갯수:" + count);
		// 해당 시간 정보를 저장할 녀석 하나 생성
		TalentTimeUtil rootTime = new TalentTimeUtil();
		// 저장될 객체 .. 갯수 저장 및 원데이 항목 설정
		rootTime.setCount(count);
		rootTime.setOneday(1);
		Map<String, TalentTimeUtil> m = new HashMap<>();
		for (int j = 0; j < count; j++) {
			if (j == 0) {
				zone1 = (HashMap<String, Object>) timeMap.get("zone1");
				TalentTimeUtil tempTime = new TalentTimeUtil();// 시간 저장 유틸
				tempTime.setZone_id((String) zone1.get("zoneid"));
				tempTime = insertTime(tempTime, zone1);
				m.put("zone1", tempTime);
				rootTime.setTimeData(m);

			}
			if (j == 1) {
				zone2 = (HashMap<String, Object>) timeMap.get("zone2");
				TalentTimeUtil tempTime = new TalentTimeUtil();
				tempTime.setZone_id((String) zone2.get("zoneid"));
				tempTime = insertTime(tempTime, zone2);
				m.put("zone2", tempTime);
				rootTime.setTimeData(m);
			}
			if (j == 2) {
				zone3 = (HashMap<String, Object>) timeMap.get("zone3");
				TalentTimeUtil tempTime = new TalentTimeUtil();
				tempTime.setZone_id((String) zone3.get("zoneid"));
				tempTime = insertTime(tempTime, zone3);
				m.put("zone3", tempTime);
				rootTime.setTimeData(m);
			}

		}
		TuTorVO vo = (TuTorVO) session.getAttribute("tutorVO");		
		saveTimeData.put(vo.getTt_no(), rootTime);
		System.out.println("원데이 항목에서 저장되는 튜터의 넘버 : "+vo.getTt_no());
		
		return "success";
	}

	// 튜터등록 버튼 클릭시 처리해주는 녀석
	@RequestMapping(value = "/tutorPage/talentRegi", method = RequestMethod.POST)
	public String regiTalent(TalentVO talentVO, Talent_contentVO contentVO, HttpSession session,
			TalentInfo talentInfo) {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// hash map 에 저장되어있는 시간 가져오기
		TuTorVO vo = (TuTorVO) session.getAttribute("tutorVO");
		TalentTimeUtil timeUtil  = null;
		//int count1  = 1;
		
		while(true) {
			timeUtil = saveTimeData.get(vo.getTt_no());
			if(timeUtil != null) {
				//가져온 데이터 지우기
				saveTimeData.remove(vo.getTt_no());
				break;
			}
			//count1 ++;
			//System.out.println(count1);			
		}
		
		
		System.out.println("등록 로직에서 가져온 timeUitl의 정보 :"+timeUtil.toString());
		// 내용 등록 서비스
		System.out.println("등록로직에서 가져온 튜터의 넘버 : "+vo.getTt_no());
		talentInsertService.insertTalent(talentVO, contentVO, talentInfo, vo, timeUtil);

		return "redirect:/clientPage"; //마이페이지로 넘기기
	}

	public Tutor_PropSearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(Tutor_PropSearchService searchService) {
		this.searchService = searchService;
	}

	// 전송된 날짜와 시간의 값을 저장하고 타임유틸에 해당요일에 해당하는 key값을 저장해서 리턴해주는 메서드
	public TalentTimeUtil insertTime(TalentTimeUtil talentTimeUtil, HashMap<String, Object> hashMap) {

		List<TalentOneDayTimeVO> list = new ArrayList<>(); // 원데이 형식을 list 에 저장 ...

		if (hashMap.get("day1") != "") {
			String tempDay = ((String) hashMap.get("day1"));
			Date tempDate = StringParseDate(tempDay);
			int dayNum = knowDay(tempDate);
			// 일요일에다가 어떻게 널수 있을까???????????????? 일단 시간의 값을 가져와보자
			String dayTime = (String) hashMap.get("t1");
			TalentOneDayTimeVO oneDayVO = new TalentOneDayTimeVO();
			oneDayVO.setDay1(new java.sql.Date(tempDate.getTime())); // 해당 date를 sql date로 변환
			oneDayVO.setDay1Time(dayTime); // 시간 값 저장
			oneDayVO.setDayOfWekk(dayNum); // 무슨 요일인지 저장
			list.add(oneDayVO); // 값이 저장되 있는 녀석을 list 에 저장
		}

		if (hashMap.get("day2") != "") {
			String tempDay = ((String) hashMap.get("day2"));
			Date tempDate = StringParseDate(tempDay);
			int dayNum = knowDay(tempDate);
			String dayTime = (String) hashMap.get("t2");
			// 같은 요일인지 확인하기
			TalentOneDayTimeVO beforeOneTimeVO = list.get(0);
			if (dayNum == beforeOneTimeVO.getDayOfWekk()) { // 같은요일이라면
				beforeOneTimeVO.setDay2(new java.sql.Date(tempDate.getTime()));
				beforeOneTimeVO.setDay2Time(dayTime);
				list.remove(0); // 저장된 index를 지우고 다시 집어넣는다.
				list.add(beforeOneTimeVO);
			} else { // 다른 요일이라면
				TalentOneDayTimeVO oneDayVO = new TalentOneDayTimeVO();
				oneDayVO.setDay1(new java.sql.Date(tempDate.getTime())); // 해당 date를 sql date로 변환
				oneDayVO.setDay1Time(dayTime); // 시간 값 저장
				oneDayVO.setDayOfWekk(dayNum); // 무슨 요일인지 저장
				list.add(oneDayVO); // 값이 저장되 있는 녀석을 list 에 저장
			}
		}
		if (hashMap.get("day3") != "") {
			String tempDay = ((String) hashMap.get("day3"));
			Date tempDate = StringParseDate(tempDay);
			int dayNum = knowDay(tempDate);
			String dayTime = (String) hashMap.get("t3");
			// 같은 요일있는지 확인하기...
			for (int i = 0; i < list.size(); i++) {
				TalentOneDayTimeVO beforeOneTimeVO = list.get(i);

				if (dayNum == beforeOneTimeVO.getDayOfWekk()) { // 같은요일이라면
					if (beforeOneTimeVO.getDay2() != null) { // day2가 저장이 안되있다면
						beforeOneTimeVO.setDay2(new java.sql.Date(tempDate.getTime()));
						beforeOneTimeVO.setDay2Time(dayTime);
						list.remove(i); // 저장된 index를 지우고 다시 집어넣는다.
						list.add(beforeOneTimeVO);
					} else { // day3 에 저장되는 경우
						beforeOneTimeVO.setDay3(new java.sql.Date(tempDate.getTime()));
						beforeOneTimeVO.setDay3Time(dayTime);
						list.remove(i); // 저장된 index를 지우고 다시 집어넣는다.
						list.add(beforeOneTimeVO);
					}
				} else { // 다른 요일이라면
					TalentOneDayTimeVO oneDayVO = new TalentOneDayTimeVO();
					oneDayVO.setDay1(new java.sql.Date(tempDate.getTime())); // 해당 date를 sql date로 변환
					oneDayVO.setDay1Time(dayTime); // 시간 값 저장
					oneDayVO.setDayOfWekk(dayNum); // 무슨 요일인지 저장
					list.add(oneDayVO); // 값이 저장되 있는 녀석을 list 에 저장
				}
			}

		}

		// 저장된 상황을 확인한다.
		for (TalentOneDayTimeVO vo : list) {		
			// db 에 해당 내용을 넣고 저장된 key값을 받아서 유틸객체에 집어 넣는다....
			int key = talentTimeInsertService.insertOneDayTime(vo);
			System.out.println("원데이 타임 체크 ...");
			System.out.println(vo.toString());
			int dayKey = vo.getDayOfWekk(); // 요일을 담고 있는 녀석
			switch (dayKey) {
			case 1:
				talentTimeUtil.setSun_onday(key);
				break; // 일요일
			case 2:
				talentTimeUtil.setMon_onday(key);
				break;
			case 3:
				talentTimeUtil.setTue_onday(key);
				break;
			case 4:
				talentTimeUtil.setWed_onday(key);
				break;
			case 5:
				talentTimeUtil.setTur_onday(key);
				break;
			case 6:
				talentTimeUtil.setFri_onday(key);
				break;
			case 7:
				talentTimeUtil.setSat_onday(key);
				break; // 토요일
			}
		}
		// 모든 값이 저장된 타임 유틸을 반환한다.
		return talentTimeUtil;
	}

	/**
	 * 
	 * @param String
	 *            (날짜의 문자열로 표현된 형식)
	 * @return int = 1~7 월화수목금토일 무슨요일인지 리턴
	 * @throws ParseException
	 */
	public int knowDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 
	 * @param String
	 *            date
	 * @return String 날짜형식을 넣으면 Date형식의 날짜를 리턴해주는 녀석
	 */
	public Date StringParseDate(String date) {
		System.out.println("받아온 날짜 데이터 : "+date);		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//구분자로 자르기		
		Date nDate = null;
		try {
			nDate = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("변환된 날짜 데이터 : "+nDate);
		return nDate;
	}

}
