package com.zest.web.client.service.client;

import com.zest.web.client.model.ClientVO;

public interface ClientUpdateService {
	
	//마지막 로그인 업데이트
	void clientLastLogin(ClientVO vo);
}
