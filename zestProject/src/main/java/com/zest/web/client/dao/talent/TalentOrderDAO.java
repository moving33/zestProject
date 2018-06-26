package com.zest.web.client.dao.talent;

import com.zest.web.client.model.Talent_OrderVO;

//결제
public interface TalentOrderDAO {
	//결제 
	int insertTO(Talent_OrderVO vo);
}
