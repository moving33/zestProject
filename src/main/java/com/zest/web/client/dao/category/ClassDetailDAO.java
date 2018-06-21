package com.zest.web.client.dao.category;

import java.util.List;

import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.ReviewVO;
import com.zest.web.client.model.TalentInfo;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;
import com.zest.web.client.model.Talent_info;

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
}
