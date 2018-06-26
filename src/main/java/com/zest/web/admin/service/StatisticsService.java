package com.zest.web.admin.service;

import java.util.Map;

// 통계 서비스
public interface StatisticsService {
	
	// 카테고리별 누적 인원 수
	Map<String, Object> getCount();
	
	// 카테고리별 누적 인원 수
	Map<String, Object> getCateCount();
}
