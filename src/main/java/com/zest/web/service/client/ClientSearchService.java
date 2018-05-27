package com.zest.web.service.client;

import java.util.List;

import com.zest.web.model.ClientVO;

public interface ClientSearchService {
	
	//개별 회원 검색 서비스
	ClientVO getClient(ClientVO clientVO);
	
	//회원 리스트로 검색 서비스
	List<ClientVO> getClientList(ClientVO clientVO);
	
}
