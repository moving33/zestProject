package com.zest.web.client.dao.talent;

import com.zest.web.client.model.TalentVO;

public interface TalentDAO {
	
	//강의를 등록하고 , 등록한 강의의 primary key를 리턴하는 method
	int insertTalent(TalentVO vo);
}
