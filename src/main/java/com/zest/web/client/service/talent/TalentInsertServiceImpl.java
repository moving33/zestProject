package com.zest.web.client.service.talent;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zest.web.client.dao.talent.TalentDAO;
import com.zest.web.client.model.TalentInfo;
import com.zest.web.client.model.TalentTimeUtil;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;
import com.zest.web.client.model.TuTorVO;

@Service
public class TalentInsertServiceImpl implements TalentInsertService{
	
	@Autowired
	private TalentDAO talentDAO;

	//강의 등록하기
	@Override
	@Transactional
	public void insertTalent(TalentVO talentVO, Talent_contentVO contentVO, TalentInfo talentInfo, TuTorVO tutorVO,
			TalentTimeUtil timeUtil) {
		//몇 회차 수업인지 알아내고 값 저장하기
		int meet_count = contentVO.getTc_curriculum().length;
		talentVO.setTalent_meet_count(meet_count);
		//total Price 넣기 
		talentVO.setTalent_total_price(talentVO.getTalent_price_hour()*talentVO.getTalent_meet_count()*talentVO.getTalent_meet_time());
		//등록한 튜터의 no 넣기com
		talentVO.setTalent_tt_no(tutorVO.getTt_no());
		//talent 내용 넣고 넣은 talent의 primary key 받아오기
		System.out.println(talentVO.toString());
		int no = talentDAO.insertTalent(talentVO);
		
		System.out.println(no);
		
		
		/*//프로필 사진 폴더에 업로드하기
		File tutorPropFolder = new File("c:/zest/tutorProp/"+tutorProp_no);
		if (!tutorPropFolder.exists()) {
			// 해당 폴더가 없으면 생성
			tutorPropFolder.mkdirs();
		}
		*/
	}
	
	
		
}
