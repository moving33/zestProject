package com.zest.web.client.dao.tutor;

import com.zest.web.client.model.TuTorVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TutorDAOImpl implements TutorDAO {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    //내용 넣기
    @Override
    public TuTorVO insertTutor(TuTorVO tuTorVO) {
        sqlSessionTemplate.insert("com.zest.tutor.insertTutor",tuTorVO);
        return tuTorVO;
    }
    
    

    @Override
	public void updateTutorImage(TuTorVO torVO) {
		sqlSessionTemplate.update("com.zest.tutor.updateImagePathTutor",torVO);		
	}



	public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
