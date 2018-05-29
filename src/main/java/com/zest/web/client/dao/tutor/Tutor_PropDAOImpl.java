package com.zest.web.client.dao.tutor;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.Tutor_PropVO;

@Repository
public class Tutor_PropDAOImpl implements Tutor_PropDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private Logger logger = LoggerFactory.getLogger(Tutor_PropDAOImpl.class);
	
	//추가
	@Override
	public void insertTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		sqlSessionTemplate.insert("com.zest.tutorProp.insertTutorProp",vo);

	}

	//상태 업데이트 
	@Override
	public void updateTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		sqlSessionTemplate.update("com.zest.tutorProp.updateTutorProp",vo);

	}

	@Override
	public Tutor_PropVO getTutor_prop(Tutor_PropVO vo) {
		logger.info("...ing");
		return sqlSessionTemplate.selectOne("com.zest.tutorProp.searchTutorProp",vo);
	}

	@Override
	public List<Tutor_PropVO> getListTutor_prop(Tutor_PropVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	

}
