package com.zest.web.client.dao.category;

import java.util.List;

import com.zest.web.client.model.CategoryVO;

public interface CategoryDAO {
	
	//카테고리 리스트를 불러오는 DAO
	List<CategoryVO> getCategoryList();

}
