package com.zest.web.client.dao.category;

import java.util.List;

import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.ReviewVO;
import com.zest.web.client.model.TalentOneDayTimeVO;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_info;
import com.zest.web.client.model.Talent_notOneDayTime;

public interface ClassDetailDAO {

	// 강의디테일 불러오기
	List<ClassDetailVO> classCall(Integer talent_no);
	//talent_content 불러오기
	ClassDetailVO contentCall(Integer talent_no);
	//talent 불러오기
	TalentVO talentCall(Integer talent_no);
	//tutor 정보 불러오기
	ClassDetail_TutorVO tutorCall(Integer talent_no);
	//review 불러오기
	List<ReviewVO> reviewCall(Integer talent_no);
	//review 값 평균 불러오기
	ReviewVO reviewValue(Integer talent_no);
	
	//ZONE & DAY 불러오기 (TALENT_INFO)
	List<Talent_info> zoneDayCall(Integer talent_no);
	//원데이 아닌시간 가져오기
	Talent_notOneDayTime getTalent_notOneDayTime(Talent_notOneDayTime vo);
	//원데이 시간 가져오기
	TalentOneDayTimeVO getTalent_OnedayTime(TalentOneDayTimeVO vo);
	
	
	//리뷰 카운트
	Integer getReviewCount(Integer talent_no);
	//리뷰 리스트 불러오기
	List<ReviewVO> getReviewList(Object obj);
}
