package com.zest.web.client.service.talent.time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.client.dao.talent.TalentDAO;
import com.zest.web.client.model.Talent_OneDayTimeVO;

@Service
public class TalentTimeInsertServiceImpl implements TalentTimeInsertService{
	
	
	@Autowired
	private TalentDAO talentDAO;
	

	@Override
	public int insertOneDayTime(Talent_OneDayTimeVO vo) {
		return talentDAO.insertOneDayTime(vo);
	}
		
	

}
