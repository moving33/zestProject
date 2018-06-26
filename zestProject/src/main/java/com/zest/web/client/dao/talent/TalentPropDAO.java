package com.zest.web.client.dao.talent;

import com.zest.web.client.model.TalentPropVO;

//수업 신청 DAO
public interface TalentPropDAO {
	
	//수업 신청
	void insertTP(TalentPropVO vo);
	
	//결제완료시 업데이트
	void completeProp(TalentPropVO vo);
	
}
