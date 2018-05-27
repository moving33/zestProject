package com.zest.web.dao.category;

import java.util.List;

import com.zest.web.model.CategoryVO;

public interface CategoryDAO {
	
	//카테고리 리스트를 불러오는 DAO
	List<CategoryVO> getCategoryList();

}
