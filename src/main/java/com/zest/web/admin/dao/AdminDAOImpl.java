package com.zest.web.admin.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.admin.model.AdminVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 관리자 등록
	public void adminRegi(AdminVO vo) {
		sqlSessionTemplate.insert("com.zest.admin.insertAdmin", vo);
	}
	
	// 관리자 조회
	public AdminVO adminSearch(AdminVO vo) {
		vo = sqlSessionTemplate.selectOne("com.zest.admin.searchAdmin", vo); 
		return vo != null ? vo : null;
	}
	
}
