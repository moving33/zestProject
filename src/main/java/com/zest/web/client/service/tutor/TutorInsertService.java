package com.zest.web.client.service.tutor;

import com.zest.web.client.model.ClientVO;
import com.zest.web.client.model.TuTorVO;
import com.zest.web.client.model.Tutor_PropVO;

public interface TutorInsertService {

    //튜터 data를 insert하는 메서드
    TuTorVO tutorInsert(Tutor_PropVO tutor_propVO, ClientVO clientVO);
}
