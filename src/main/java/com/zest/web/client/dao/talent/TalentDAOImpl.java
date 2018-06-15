package com.zest.web.client.dao.talent;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;
import com.zest.web.client.model.Talent_info;
import com.zest.web.client.model.Talent_notOneDayTime;

@Repository
public class TalentDAOImpl implements TalentDAO {

	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertTalent(TalentVO vo) {
		session.insert("com.zest.talent.insertTalent",vo);
		return vo.getTalent_no();
	}

	@Override
	public void insertTC(Talent_contentVO vo) {
		session.insert("com.zest.talentContent.insertTC",vo);
	}

	@Override
	public int insertNotOneDayTime(Talent_notOneDayTime vo) {
		session.insert("com.zest.talent_NotOneDay.insertNotOneDayTime",vo);
		return vo.getTt_nod_no();
	}

	@Override
	public void insertTI(Talent_info vo) {
		session.insert("com.zest.talent_Info.insertTI",vo);		
	}
	
	
	
	
	
	

}
