package com.zest.web.client.service.tutor;

import java.util.List;

import com.zest.web.client.model.Tutor_PropVO;

//튜터 신청테이블 검색 서비스
public interface Tutor_PropSearchService {
	
	
	//개별검색
	Tutor_PropVO getTutor_prop(Tutor_PropVO vo);
	
	//리스트 검색
	List<Tutor_PropVO> getListTutor_prop(Tutor_PropVO vo);
}
