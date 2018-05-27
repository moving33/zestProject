package com.zest.web.dao.client;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zest.web.model.ClientVO;

//ClientDAO 객체 구현 클래스
@Repository
public class ClientDAOImpl implements ClientDAO {
	
	private Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	//client 가입
	@Override
	public void insertClient(ClientVO clientVO) {
		logger.info("..ing");
		logger.info(clientVO.toString());
		sqlSessionTemplate.insert("com.zest.client.insertClient",clientVO);		
	}

	@Override
	public void deleteClient(ClientVO clientVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClientVO> getClientList(ClientVO clientVO) {
		// TODO Auto-generated method stub
		return null;
	}

	//client 조회
	@Override
	public ClientVO getClient(ClientVO clientVO) {
		logger.info("..ing");
		
		ClientVO vo = sqlSessionTemplate.selectOne("com.zest.client.getClient",clientVO);		
		//해당 클라이언트가 존재하면 클라이언트를 넘기고 아니면 null값을 전송한다.
		return vo != null ? vo : null; 
		
		
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	
	
	
	
	

}
