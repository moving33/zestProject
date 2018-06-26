package com.zest.web.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.admin.model.StatisticsVO;

@Repository
public class StatisticsDAOImpl implements StatisticsDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 카테고리별 누적 인원 수
	public Integer getCount(StatisticsVO vo){
		return sqlSessionTemplate.selectOne("com.zest.statistics.getCount", vo);
	}
	
	// 카테고리별 누적 인원 수
	public Integer getCateCount(StatisticsVO vo){
		return sqlSessionTemplate.selectOne("com.zest.statistics.getCateCount", vo);
	}
	
}
