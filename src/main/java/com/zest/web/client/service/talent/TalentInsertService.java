package com.zest.web.client.service.talent;

import com.zest.web.client.model.TalentInfo;
import com.zest.web.client.model.TalentTimeUtil;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;
import com.zest.web.client.model.TuTorVO;

//강의 등록 서비스
public interface TalentInsertService {
	
	//강의등록 서비스
	void insertTalent(TalentVO talentVO, Talent_contentVO contentVO,TalentInfo talentInfo,TuTorVO tutorVO,TalentTimeUtil timeUtil);
}
