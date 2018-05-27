package com.zest.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.dao.category.LectureDAO;
import com.zest.web.model.LectureVO;

@Service
public class LectureServiceImpl implements LectureService {
	
	@Autowired
	private LectureDAO lectureDAO;
	
	//카테고리(소/강의) 리스트를 가져오는 메서드 
	@Override
	public List<LectureVO> getLectureList(LectureVO lectureVO) {
		
		return lectureDAO.getLectureList(lectureVO);
		
	}

	public void setLectureDAO(LectureDAO lectureDAO) {
		this.lectureDAO = lectureDAO;
	}
	
	

}
