package com.zest.web.client.controller.category;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.Paging;
import com.zest.web.client.model.ReviewVO;
import com.zest.web.client.model.TalentOneDayTimeVO;
import com.zest.web.client.model.TalentTimeUtil;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_info;
import com.zest.web.client.model.Talent_notOneDayTime;
import com.zest.web.client.service.client.ClassDetailService;

@Controller
public class ClassDetailController {

	@Autowired
	ClassDetailService classDetailService;
	
	@Autowired
	Paging paging;
	

	@RequestMapping(value = "/talent/{talent_no}")
	public ModelAndView classDetail(@PathVariable int talent_no, ModelAndView modelAndView, ClassDetailVO vo,
			TalentVO Tvo, ClassDetail_TutorVO Cvo, @RequestParam(required = false) String pageNum) {
		System.out.println("2222222222222");
		System.out.println(talent_no);
		vo = classDetailService.contentCall(talent_no);
		Tvo = classDetailService.talentCall(talent_no);
		Cvo = classDetailService.tutorCall(talent_no);
		
		
		
		// View에서 사용할 이미지

		Map<String, Object> model = new HashMap<>(); // model 저장할 MAP

		File dirFile = new File(vo.getTc_image_path()); // 파일경로 c:\zest\talent\MUSIC\3
		File[] files = dirFile.listFiles(); // 파일 담기
		List<String> images = new ArrayList<String>();

		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile()) {
				String tempPath = files[i].getParent();
				String tempFileName = files[i].getName();

				String subPath = tempPath.substring(8);

				/*
				 * System.out.println("sub Path : " + subPath);
				 * System.out.println("tempPtah 값 : " + tempPath);
				 * System.out.println("tempFileName 값: " + tempFileName);
				 */

				String imagePath = "/LocalImage/" + subPath + "/" + tempFileName;

				// model.put("image" + i, "/LocalImage/" + subPath + "/" + tempFileName);

				images.add(imagePath);

			}
		}
		
		//------------------------------------------페이징처리하기
		if (pageNum == null || pageNum == "")
			pageNum = "1";

		// 현재페이지
		int currentPage = Integer.parseInt(pageNum); // 현재 페이지 번호
		int pageSize = 5; // 페이지당 보여줄 글
		int pageBlockSize = 3; // 페이지 블록의 사이즈
		
		

		//총 글 수 가져오기
		int count = classDetailService.getReviewCount(talent_no);
		System.out.println("페이지의 총 갯수 : " + count);
		
		//페이징처리 설정
		paging.setPaging(pageSize, pageBlockSize, count, currentPage);
		// 페이지에서 가져올 글 설정
		
		System.out.println("스타트 로우  : " + paging.getWriting_Start().toString());
		System.out.println("엔드 로우 : " + paging.getWriting_End().toString());
		model.put("startRow", paging.getWriting_Start());
		model.put("endRow", paging.getWriting_End());
		model.put("talent_no", talent_no);
		
		// 리뷰 보여주기
		List<ReviewVO> Rvo = classDetailService.getReviewList(model);
		System.out.println("Review VOOOOOOO 리스트 : " + Rvo.toString());
		model.put("review", Rvo);
		model.put("pageNum", pageNum);
		model.put("count", count);
		model.put("bp", paging);
		
		//------------------------------------------페이징처리하기
				

		
		
		// 커리큘럼 회차 나누기
		String date = vo.getTc_curriculum(); // 커리큘럼 뽑아오기
		String delimiter = "!@#%";

		String[] curri_Arr = date.split(delimiter);

		modelAndView.addObject("cur", curri_Arr);

		// 지워도 되는것
		for (int i = 0; i < curri_Arr.length; i++) {
			model.put("curri" + i, i + 1 + "회차" + curri_Arr[i]);

		}
		
		//지도에서 쓸 좌표
		String com = vo.getTc_location(); //좌표값 뽑아오기
		String del = ",";
		
		String[] arr = com.split(del);
		
		for(int i=0; i<arr.length; i++) {
			model.put("com" + i, arr[i]);
		}

		// 프로필 이미지 사진

		File pro = new File(Cvo.getTt_im_path());
		File[] profile = pro.listFiles();

		for (int i = 0; i < profile.length; i++) {
			if (profile[i].isFile()) {

				String proimg = profile[i].getParent();
				String proname = profile[i].getName();

				String subPro = proimg.substring(8);

				// System.out.println("서브프로로로로로로로로로 = " + subPro);
				// System.out.println("프로네임임 : " + proname);

				model.put("pro" + i, "/LocalImage/" + subPro + "/" + proname);
			}

		}
		modelAndView.addObject("imgPath", images);

		/*// 리뷰 보여주기
		List<ReviewVO> Rvo = classDetailService.reviewCall(talent_no);
		model.put("review", Rvo);*/

		// 리뷰 평균 값
		ReviewVO avgReview = classDetailService.reviewValue(talent_no);
		model.put("avg", avgReview);
		model.put("avg2", avgReview);

		
		
		
		
		
		// 위치(zone) 요일(day) 얻어오기
		List<Talent_info> InfoVo = classDetailService.zoneDayCall(talent_no);

		// 위치 보여주기
		model.put("zone", InfoVo);
		//System.out.println("인포 VO 121212121" + InfoVo.toString());

		Map<String, Object> weekDay = new HashMap<>(); // 요일별 저장map
		// List<Talent_notOneDayTime> notOnedayList = new ArrayList<>();
		List<TalentOneDayTimeVO> onedayList = new ArrayList<>();

		for (int i = 0; i < InfoVo.size(); i++) {
			Talent_info infoVO = InfoVo.get(i);
			if (infoVO.getTi_status() == 0) { // 0이면 원데이가 아님
				////////////////////////////월요일//////////////////////////
				if (infoVO.getTi_mon() != null) {
					if (infoVO.getTi_mon() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("mon" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						Talent_notOneDayTime vo_not = new Talent_notOneDayTime();
						vo_not.setTt_nod_no(infoVO.getTi_mon());
						vo_not = classDetailService.getTalent_notOneDayTime(vo_not);
						if (vo_not.getTime1() != null) {
							dayDataList.add(vo_not.getTime1());
						}
						if (vo_not.getTime2() != null) {
							dayDataList.add(vo_not.getTime2());
						}
						if (vo_not.getTime3() != null) {
							dayDataList.add(vo_not.getTime3());
						}
						weekDay.put("mon" + (i + 1), dayDataList);
					}
				}
				////////////////////////////화요일//////////////////////////
				if (infoVO.getTi_tue() != null) {
					if (infoVO.getTi_tue() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("tue" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						Talent_notOneDayTime vo_not = new Talent_notOneDayTime();
						vo_not.setTt_nod_no(infoVO.getTi_tue());
						vo_not = classDetailService.getTalent_notOneDayTime(vo_not);
						if (vo_not.getTime1() != null) {
							dayDataList.add(vo_not.getTime1());
						}
						if (vo_not.getTime2() != null) {
							dayDataList.add(vo_not.getTime2());
						}
						if (vo_not.getTime3() != null) {
							dayDataList.add(vo_not.getTime3());
						}
						weekDay.put("tue" + (i + 1), dayDataList);
					}
				}
				////////////////////////////수요일//////////////////////////
				if (infoVO.getTi_wed() != null) {
					if (infoVO.getTi_wed() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("tue" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						Talent_notOneDayTime vo_not = new Talent_notOneDayTime();
						vo_not.setTt_nod_no(infoVO.getTi_wed());
						vo_not = classDetailService.getTalent_notOneDayTime(vo_not);
						if (vo_not.getTime1() != null) {
							dayDataList.add(vo_not.getTime1());
						}
						if (vo_not.getTime2() != null) {
							dayDataList.add(vo_not.getTime2());
						}
						if (vo_not.getTime3() != null) {
							dayDataList.add(vo_not.getTime3());
						}
						weekDay.put("wed" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 목요일//////////////////////////
				if (infoVO.getTi_tur() != null) {
					if (infoVO.getTi_tur() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("tue" + i + 1, dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						Talent_notOneDayTime vo_not = new Talent_notOneDayTime();
						vo_not.setTt_nod_no(infoVO.getTi_tur());
						vo_not = classDetailService.getTalent_notOneDayTime(vo_not);
						if (vo_not.getTime1() != null) {
							dayDataList.add(vo_not.getTime1());
						}
						if (vo_not.getTime2() != null) {
							dayDataList.add(vo_not.getTime2());
						}
						if (vo_not.getTime3() != null) {
							dayDataList.add(vo_not.getTime3());
						}
						weekDay.put("tur" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 금요일//////////////////////////
				if (infoVO.getTi_fri() != null) {
					if (infoVO.getTi_fri() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("tue" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						Talent_notOneDayTime vo_not = new Talent_notOneDayTime();
						vo_not.setTt_nod_no(infoVO.getTi_fri());
						vo_not = classDetailService.getTalent_notOneDayTime(vo_not);
						if (vo_not.getTime1() != null) {
							dayDataList.add(vo_not.getTime1());
						}
						if (vo_not.getTime2() != null) {
							dayDataList.add(vo_not.getTime2());
						}
						if (vo_not.getTime3() != null) {
							dayDataList.add(vo_not.getTime3());
						}
						weekDay.put("fri" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 토요일//////////////////////////
				if (infoVO.getTi_sat() != null) {
					if (infoVO.getTi_sat() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("sat" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						Talent_notOneDayTime vo_not = new Talent_notOneDayTime();
						vo_not.setTt_nod_no(infoVO.getTi_sat());
						vo_not = classDetailService.getTalent_notOneDayTime(vo_not);
						if (vo_not.getTime1() != null) {
							dayDataList.add(vo_not.getTime1());
						}
						if (vo_not.getTime2() != null) {
							dayDataList.add(vo_not.getTime2());
						}
						if (vo_not.getTime3() != null) {
							dayDataList.add(vo_not.getTime3());
						}
						weekDay.put("sat" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 일요일//////////////////////////
				if (infoVO.getTi_sun() != null) {
					if (infoVO.getTi_sun() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("sun" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						Talent_notOneDayTime vo_not = new Talent_notOneDayTime();
						vo_not.setTt_nod_no(infoVO.getTi_sun());
						vo_not = classDetailService.getTalent_notOneDayTime(vo_not);
						if (vo_not.getTime1() != null) {
							dayDataList.add(vo_not.getTime1());
						}
						if (vo_not.getTime2() != null) {
							dayDataList.add(vo_not.getTime2());
						}
						if (vo_not.getTime3() != null) {
							dayDataList.add(vo_not.getTime3());
						}
						weekDay.put("sun" + (i + 1), dayDataList);
					}
				}
			} else { // 원데이(1이면 원데이)
				////////////////////////////월요일//////////////////////////
				if(infoVO.getTi_mon() != null) {
					if(infoVO.getTi_mon() == 0 ) { //시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("mon" + (i + 1), dayDataList);
					} else { //저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						TalentOneDayTimeVO vo_one = new TalentOneDayTimeVO();
						
						vo_one.setTt_od_no(infoVO.getTi_mon());
						vo_one = classDetailService.getTalent_OnedayTime(vo_one);
						if(vo_one.getDay1() != null) {
							String day1 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay1());
							dayDataList.add(day1);
							dayDataList.add(vo_one.getDay1Time());
						}if(vo_one.getDay2() != null) {
							String day2 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay2());
							dayDataList.add(day2);
							dayDataList.add(vo_one.getDay2Time());
						}if(vo_one.getDay3() != null) {
							String day3 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay3());
							dayDataList.add(day3);
							dayDataList.add(vo_one.getDay3Time());
						}
						weekDay.put("mon" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 화요일//////////////////////////
				if (infoVO.getTi_tue() != null) {
					if (infoVO.getTi_tue() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("tue" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						TalentOneDayTimeVO vo_one = new TalentOneDayTimeVO();

						vo_one.setTt_od_no(infoVO.getTi_tue());
						vo_one = classDetailService.getTalent_OnedayTime(vo_one);
						if (vo_one.getDay1() != null) {
							String day1 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay1());
							dayDataList.add(day1);
							dayDataList.add(vo_one.getDay1Time());
						}
						if (vo_one.getDay2() != null) {
							String day2 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay2());
							dayDataList.add(day2);
							dayDataList.add(vo_one.getDay2Time());
						}
						if (vo_one.getDay3() != null) {
							String day3 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay3());
							dayDataList.add(day3);
							dayDataList.add(vo_one.getDay3Time());
						}
						weekDay.put("tue" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 수요일//////////////////////////
				if (infoVO.getTi_wed() != null) {
					if (infoVO.getTi_wed() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("wed" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						TalentOneDayTimeVO vo_one = new TalentOneDayTimeVO();

						vo_one.setTt_od_no(infoVO.getTi_wed());
						vo_one = classDetailService.getTalent_OnedayTime(vo_one);
						if (vo_one.getDay1() != null) {
							String day1 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay1());
							dayDataList.add(day1);
							dayDataList.add(vo_one.getDay1Time());
						}
						if (vo_one.getDay2() != null) {
							String day2 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay2());
							dayDataList.add(day2);
							dayDataList.add(vo_one.getDay2Time());
						}
						if (vo_one.getDay3() != null) {
							String day3 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay3());
							dayDataList.add(day3);
							dayDataList.add(vo_one.getDay3Time());
						}
						weekDay.put("wed" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 목요일//////////////////////////
				if (infoVO.getTi_tur() != null) {
					if (infoVO.getTi_tur() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("tur" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						TalentOneDayTimeVO vo_one = new TalentOneDayTimeVO();

						vo_one.setTt_od_no(infoVO.getTi_tur());
						vo_one = classDetailService.getTalent_OnedayTime(vo_one);
						if (vo_one.getDay1() != null) {
							String day1 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay1());
							dayDataList.add(day1);
							dayDataList.add(vo_one.getDay1Time());
						}
						if (vo_one.getDay2() != null) {
							String day2 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay2());
							dayDataList.add(day2);
							dayDataList.add(vo_one.getDay2Time());
						}
						if (vo_one.getDay3() != null) {
							String day3 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay3());
							dayDataList.add(day3);
							dayDataList.add(vo_one.getDay3Time());
						}
						weekDay.put("tur" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 금요일//////////////////////////
				if (infoVO.getTi_fri() != null) {
					if (infoVO.getTi_fri() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("fri" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						TalentOneDayTimeVO vo_one = new TalentOneDayTimeVO();

						vo_one.setTt_od_no(infoVO.getTi_fri());
						vo_one = classDetailService.getTalent_OnedayTime(vo_one);
						if (vo_one.getDay1() != null) {
							String day1 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay1());
							dayDataList.add(day1);
							dayDataList.add(vo_one.getDay1Time());
						}
						if (vo_one.getDay2() != null) {
							String day2 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay2());
							dayDataList.add(day2);
							dayDataList.add(vo_one.getDay2Time());
						}
						if (vo_one.getDay3() != null) {
							String day3 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay3());
							dayDataList.add(day3);
							dayDataList.add(vo_one.getDay3Time());
						}
						weekDay.put("fri" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 토요일//////////////////////////
				if (infoVO.getTi_sat() != null) {
					if (infoVO.getTi_sat() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("sat" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						TalentOneDayTimeVO vo_one = new TalentOneDayTimeVO();

						vo_one.setTt_od_no(infoVO.getTi_sat());
						vo_one = classDetailService.getTalent_OnedayTime(vo_one);
						if (vo_one.getDay1() != null) {
							String day1 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay1());
							dayDataList.add(day1);
							dayDataList.add(vo_one.getDay1Time());
						}
						if (vo_one.getDay2() != null) {
							String day2 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay2());
							dayDataList.add(day2);
							dayDataList.add(vo_one.getDay2Time());
						}
						if (vo_one.getDay3() != null) {
							String day3 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay3());
							dayDataList.add(day3);
							dayDataList.add(vo_one.getDay3Time());
						}
						weekDay.put("sat" + (i + 1), dayDataList);
					}
				}
				//////////////////////////// 일요일//////////////////////////
				if (infoVO.getTi_sun() != null) {
					if (infoVO.getTi_sun() == 0) { // 시간협의
						List<String> dayDataList = new ArrayList<>();
						String dayData = "시간협의";
						dayDataList.add(dayData);
						weekDay.put("sun" + (i + 1), dayDataList);
					} else { // 저장된 시간 있음
						List<String> dayDataList = new ArrayList<>();
						TalentOneDayTimeVO vo_one = new TalentOneDayTimeVO();

						vo_one.setTt_od_no(infoVO.getTi_sun());
						vo_one = classDetailService.getTalent_OnedayTime(vo_one);
						if (vo_one.getDay1() != null) {
							String day1 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay1());
							dayDataList.add(day1);
							dayDataList.add(vo_one.getDay1Time());
						}
						if (vo_one.getDay2() != null) {
							String day2 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay2());
							dayDataList.add(day2);
							dayDataList.add(vo_one.getDay2Time());
						}
						if (vo_one.getDay3() != null) {
							String day3 = new SimpleDateFormat("yyyy-MM-dd").format(vo_one.getDay3());
							dayDataList.add(day3);
							dayDataList.add(vo_one.getDay3Time());
						}
						weekDay.put("sun" + (i + 1), dayDataList);
					}
				}

			}
		}

		modelAndView.addObject("detail", vo);
		modelAndView.addObject("talent", Tvo);
		modelAndView.addObject("tutor", Cvo);
		modelAndView.addAllObjects(model);
		modelAndView.addObject("weekDay",weekDay);

		modelAndView.setViewName("category/classDetail");
		return modelAndView;
	}

}
