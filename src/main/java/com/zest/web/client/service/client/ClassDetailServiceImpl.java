package com.zest.web.client.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.category.ClassDetailDAO;
import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;


@Service
public class ClassDetailServiceImpl implements ClassDetailService {
	
	@Autowired
	ClassDetailDAO dao;

	@Override
	public List<ClassDetailVO> classCall(Integer talent_no) {
		System.out.println("classCall 메소드 : " + talent_no);
		return dao.classCall(talent_no);
	}
	
	@Override
	public ClassDetailVO contentCall(Integer talent_no) {
		System.out.println("contentCall 메소드 : " + talent_no);
		return dao.contentCall(talent_no);
	}
	
	@Override
	public TalentVO talentCall(Integer talent_no) {
		return dao.talentCall(talent_no);
	}
	
	@Override
	public ClassDetail_TutorVO tutorCall(Integer talent_no) {
		return dao.tutorCall(talent_no);
	}
	
	

	public ClassDetailDAO getDao() {
		return dao;
	}

	public void setDao(ClassDetailDAO dao) {
		this.dao = dao;
	}
	
	
	
	

}
