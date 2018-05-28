package com.zest.web.client.dao.client;

import java.util.List;

import com.zest.web.client.model.ClientVO;

public interface ClientDAO {
	
	//회원가입 
	void insertClient(ClientVO clientVO);
	//회원탈퇴
	void deleteClient(ClientVO clientVO);
	//회원조회다수
	List<ClientVO> getClientList(ClientVO clientVO);	
	//특정회원조회
	ClientVO getClient(ClientVO clientVO);
	
}
