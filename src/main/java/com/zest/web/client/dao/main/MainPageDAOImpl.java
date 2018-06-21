package com.zest.web.client.dao.main;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.client.model.CategoryPageVO;


// 메인페이지 DAO
@Repository
public class MainPageDAOImpl implements MainPageDAO {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 메인페이지 인기수업 가져오는 메서드
	@Override
	public List<CategoryPageVO> mainPageGetHotCategory(Object obj) {
		return sqlSessionTemplate.selectList("com.zest.mainPage.getHotCategory", obj);
	}

}
