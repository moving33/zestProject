package com.zest.web.client.dao.talent;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.TalentVO;

@Repository
public class TalentDAOImpl implements TalentDAO {

	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertTalent(TalentVO vo) {
		session.insert("com.zest.talent.insertTalent",vo);
		return vo.getTalent_no();
	}

}
