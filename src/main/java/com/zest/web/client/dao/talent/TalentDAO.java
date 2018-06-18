package com.zest.web.client.dao.talent;

import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;
import com.zest.web.client.model.Talent_info;
import com.zest.web.client.model.Talent_notOneDayTime;

public interface TalentDAO {
	
	//강의를 등록하고 , 등록한 강의의 primary key를 리턴하는 method
	int insertTalent(TalentVO vo);
	
	//강의 내용을 등록
	void insertTC(Talent_contentVO vo);
	
	//원데이가 아닌 항목의 시간을 등록
	int insertNotOneDayTime(Talent_notOneDayTime vo);
	
	//talent_info 테이블의 값을 등록
	void insertTI(Talent_info vo);
}
