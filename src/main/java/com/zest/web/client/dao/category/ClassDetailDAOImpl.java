package com.zest.web.client.dao.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.ClassDetailVO;
import com.zest.web.client.model.ClassDetail_TutorVO;
import com.zest.web.client.model.TalentVO;
import com.zest.web.client.model.Talent_contentVO;


@Repository
public class ClassDetailDAOImpl implements ClassDetailDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ClassDetailVO> classCall(Integer talent_no) {
		System.out.println("classCall 메서드 : " + talent_no);
		List<ClassDetailVO> vo = sqlSession.selectList("com.zest.classDetail.getClass", talent_no);

		return vo;
	}
	
	
	@Override
	public ClassDetailVO contentCall(Integer talent_no) {
		ClassDetailVO vo = sqlSession.selectOne("com.zest.classDetail.ContentClass", talent_no);
		System.out.println("DAO Impl" + vo.toString());
		return vo;
	}
	
	@Override
	public TalentVO talentCall(Integer talent_no) {
		TalentVO vo = sqlSession.selectOne("com.zest.classDetail.talentClass", talent_no);
		return vo;
	}
	
	@Override
	public ClassDetail_TutorVO tutorCall(Integer talent_no) {
		ClassDetail_TutorVO vo = sqlSession.selectOne("com.zest.classDetail.talentInfo", talent_no);
		return vo;
	}
	
	
	

	
	
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
	

}
