package com.zest.web.client.dao.talent;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.TalentPropVO;

@Repository
public class TalentPropDAOImpl implements TalentPropDAO {

	@Autowired
	private SqlSessionTemplate session;
	
	private String key = "com.zest.talentProp";
	
	@Override
	public void insertTP(TalentPropVO vo) {
		session.insert(key+".insertTP", vo);
	}
	
	@Override
	public void completeProp(TalentPropVO vo) {
		session.update(key+".completeProp",vo);
		
	}
	
	

}
