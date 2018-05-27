package com.zest.web.dao.category;

import java.util.List;

import com.zest.web.model.LectureVO;

public interface LectureDAO {
	
	//강의 리스트를 가져오는 메서드
	List<LectureVO> getLectureList(LectureVO lectureVO);

}
