package com.zest.web.client.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.category.ClassDetailDAO;
import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.ReviewVO;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_info;



@Service
public class ClassDetailServiceImpl implements ClassDetailService {
	
	@Autowired
	ClassDetailDAO dao;
	
	//수업상세 보기
	@Override
	public List<ClassDetailVO> classCall(Integer talent_no) {
		System.out.println("classCall 메소드 : " + talent_no);
		return dao.classCall(talent_no);
	}
	
	//talent_content 불러오기
	@Override
	public ClassDetailVO contentCall(Integer talent_no) {
		System.out.println("contentCall 메소드 : " + talent_no);
		return dao.contentCall(talent_no);
	}
	
	//talent 불러오기
	@Override
	public TalentVO talentCall(Integer talent_no) {
		return dao.talentCall(talent_no);
	}
	
	//tutor 정보 불러오기
	@Override
	public ClassDetail_TutorVO tutorCall(Integer talent_no) {
		return dao.tutorCall(talent_no);
	}
	
	//review 불러오기
	@Override
	public List<ReviewVO> reviewCall(Integer talent_no){
		return dao.reviewCall(talent_no);
	}
	
	//review 값 평균 불러오기
	@Override
	public ReviewVO reviewValue(Integer talent_no) {
		return dao.reviewValue(talent_no);
	}
	
	//ZONE & DAY 불러오기 (TALENT_INFO)
	@Override
	public List<Talent_info> zoneDayCall(Integer talent_no){
		return dao.zoneDayCall(talent_no);
	}
	
	

	public ClassDetailDAO getDao() {
		return dao;
	}

	public void setDao(ClassDetailDAO dao) {
		this.dao = dao;
	}
	
	
	
	

}
