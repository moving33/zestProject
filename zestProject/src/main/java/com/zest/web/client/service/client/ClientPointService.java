package com.zest.web.client.service.client;

import com.zest.web.client.model.ClientVO;
import com.zest.web.client.model.Client_pointVO;

//포인트 서비스
public interface ClientPointService {
	
	//결제 시 포인트 처리
	void insertCP(Client_pointVO vo);
	
	//포인트 적립결과 반영
	void updateClient_CP(ClientVO vo);
	
}
