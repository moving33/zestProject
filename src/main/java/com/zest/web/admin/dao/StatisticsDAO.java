package com.zest.web.admin.dao;

import java.util.List;

import com.zest.web.admin.model.StatisticsVO;

public interface StatisticsDAO {
	
	// 카테고리별 누적 인원 수
	Integer getCount(StatisticsVO vo);
	
	// 카테고리별 활동 수
	Integer getCateCount(StatisticsVO vo);
}
