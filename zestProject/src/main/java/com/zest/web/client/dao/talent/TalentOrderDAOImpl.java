package com.zest.web.client.dao.talent;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.Talent_OrderVO;

@Repository
public class TalentOrderDAOImpl implements TalentOrderDAO {
	
	@Autowired
	private SqlSessionTemplate session;
	
	private String path = "com.zest.talentOrder";
	
	
	@Override
	public int insertTO(Talent_OrderVO vo) {
		session.insert(path+".insertTO",vo);
		return vo.getTo_no();
	}

}
