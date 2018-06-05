package com.zest.web.admin.dao;

import com.zest.web.admin.model.AdminVO;

public interface AdminDAO {
	
	// 관리자 등록
	public void adminRegi(AdminVO vo);
	
	// 관리자 조회
	public AdminVO adminSearch(AdminVO vo);
	
	
}
