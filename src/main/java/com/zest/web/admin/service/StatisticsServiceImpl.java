package com.zest.web.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zest.web.admin.dao.StatisticsDAO;
import com.zest.web.admin.model.StatisticsVO;

//통계 서비스
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	StatisticsDAO dao;
	
	// 카테고리별 누적 인원 수
	@Override
	public Map<String, Object> getCount() {
		System.out.println("카테고리별 누적 인원 수 서비스 진입");
		String[] categoryList = {"beauty", "business", "design", "food", "language", "life", "music", "program", "sports"};
		
		List<StatisticsVO> vo = new ArrayList<StatisticsVO>(categoryList.length);
		Map<String, Object> map = new HashMap<>();
		int sum = 0;
		
		for(int i = 0; i < categoryList.length; i++) {
			StatisticsVO statis = new StatisticsVO();
			
			// vo에 카테고리를 입력
			statis.setTalent_category_id(categoryList[i]);
			
			vo.add(statis);
			System.out.println("dao에 들어갈 vo의 카테고리 이름: " + vo.get(i).getTalent_category_id());
			
			// 카테고리별 받아온 누적 인원 수
			map.put("count"+i, dao.getCount(vo.get(i)));
			sum += dao.getCount(vo.get(i));
		}
			map.put("sum", sum);
		return map;
	}
	
	// 카테고리별 활동 수
		@Override
		public Map<String, Object> getCateCount() {
			System.out.println("카테고리별 활동 수 서비스 진입");
			String[] categoryList = {"beauty", "business", "design", "food", "language", "life", "music", "program", "sports"};
			
			List<StatisticsVO> vo = new ArrayList<StatisticsVO>(categoryList.length);
			Map<String, Object> map = new HashMap<>();
			int sum = 0;
			
			for(int i = 0; i < categoryList.length; i++) {
				StatisticsVO statis = new StatisticsVO();
				
				// vo에 카테고리를 입력
				statis.setTalent_category_id(categoryList[i]);
				
				vo.add(statis);
				System.out.println("dao에 들어갈 vo의 카테고리 이름: " + vo.get(i).getTalent_category_id());
				
				// 카테고리별 받아온 활동 수
				map.put("count"+i, dao.getCateCount(vo.get(i)));
				sum += dao.getCateCount(vo.get(i));
			}
				map.put("sum", sum);
			return map;
		}

}
