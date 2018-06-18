package com.zest.web.client.service;

import java.util.List;

import com.zest.web.client.model.CategoryPageVO;

public interface CategoryPageService {
	List<CategoryPageVO> getCategoryPageList(Object obj);
	
	//가져올 글개수 카운트
	Integer getCategoryPageListCount(Object obj);
}
