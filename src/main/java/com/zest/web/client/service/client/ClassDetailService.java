package com.zest.web.client.service.client;

import java.util.List;

import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;

public interface ClassDetailService {
	
	//수업상세 보기
	List<ClassDetailVO> classCall(Integer talent_no);
	//talent_content 불러오기
	Talent_contentVO contentCall(Integer talent_no);
	//talent 불러오기
	TalentVO talentCall(Integer talent_no);
	//tutor 정보 불러오기
	ClassDetail_TutorVO tutorCall(Integer talent_no);

}
