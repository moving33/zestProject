package com.zest.web.admin.controller.tutor;

import com.zest.web.client.model.Paging;
import com.zest.web.client.model.Tutor_PropVO;
import com.zest.web.client.service.tutor.Tutor_PropSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TutorManagePageController {

    @Autowired
    private Tutor_PropSearchService tutor_propSearchService;

    @Autowired
    private Paging paging;

    //튜터신청관리페이지
    @RequestMapping(value = "/admin/tutorManager/prop")
    public ModelAndView viewPropPage(ModelAndView modelAndView,
                                     @RequestParam(required = false) String pageNum,
                                     @RequestParam(required = false) String search_type,
                                     @RequestParam(required = false) String search_text) {

        if (pageNum == null || pageNum == "") pageNum = "1";


        //현재페이지
        int currentPage = Integer.parseInt(pageNum);
        int pageSize = 7; //페이지당 보여줄 글
        int pageBlockSize = 5; // 페이지 블록의 사이즈

        //검색설정확인
        if (search_type == null) search_type = "";
        if (search_text == null) search_text = "";

        //service로 넘겨줄 map객체 생성
        Map<String, Object> map = new HashMap<>();
        map.put("search_type", search_type);
        map.put("search_text", search_text);


        //검색설정확인
        if (search_type == null) search_type = "";
        if (search_text == null) search_text = "";

        int count = tutor_propSearchService.getTutor_propCount(map);

        //페이징처리 설정
        paging.setPaging(pageSize, pageBlockSize, count, currentPage);
        //페이지에서 가져올 글 설정
        map.put("startRow", paging.getWriting_Start());
        map.put("endRow", paging.getWriting_End());
        //페이지에표시할 글 받아오기

        List<Tutor_PropVO> list = tutor_propSearchService.getListTutor_prop(map);

        if (list.isEmpty()) {
            System.out.println("aaaaa");
        }
        for (Tutor_PropVO vo : list) {
            //날짜 변환
            vo.setFormat_tpd(vo.getTp_prop_date().toString().substring(0, 19));
        }

        //View에서 사용할 녀석들 넣기
        Map<String, Object> model = new HashMap<>();

        model.put("count", count);
        model.put("tutorPropList", list);
        model.put("pageNum", pageNum);
        model.put("search_text", search_text);
        model.put("search_type", search_type);
        model.put("bp", paging);
        modelAndView.addAllObjects(model);
        modelAndView.setViewName("admin/tutorProp");
        return modelAndView;
    }


    @RequestMapping(value = "/admin/tutorManager/prop/{num}")
    public ModelAndView viewDetailPropPage(ModelAndView modelAndView,
                                           @PathVariable String num,
                                           @RequestParam(required = false) String pageNum,
                                           @RequestParam(required = false) String search_type,
                                           @RequestParam(required = false) String search_text,
                                           HttpServletRequest request) {

        if (pageNum == null || pageNum == "") pageNum = "1";
        //현재페이지
        int currentPage = Integer.parseInt(pageNum);
        int pageSize = 7; //페이지당 보여줄 글
        int pageBlockSize = 5; // 페이지 블록의 사이즈

        //검색설정확인
        if (search_type == null) search_type = "";
        if (search_text == null) search_text = "";

        //service로 넘겨줄 map객체 생성
        Map<String, Object> map = new HashMap<>();
        map.put("search_type", search_type);
        map.put("search_text", search_text);


        //검색설정확인
        if (search_type == null) search_type = "";
        if (search_text == null) search_text = "";

        int count = tutor_propSearchService.getTutor_propCount(map);

        //페이징처리 설정
        paging.setPaging(pageSize, pageBlockSize, count, currentPage);
        //페이지에서 가져올 글 설정
        map.put("startRow", paging.getWriting_Start());
        map.put("endRow", paging.getWriting_End());
        //페이지에표시할 글 받아오기

        List<Tutor_PropVO> list = tutor_propSearchService.getListTutor_prop(map);

        if (list.isEmpty()) {
            System.out.println("aaaaa");
        }
        for (Tutor_PropVO vo : list) {
            //날짜 변환
            vo.setFormat_tpd(vo.getTp_prop_date().toString().substring(0, 19));
        }
        //상세페이지 실질 내용

        Integer number = Integer.parseInt(num); //넘겨받은 번호 파싱
        Tutor_PropVO tempVo = tutor_propSearchService.getTutor_propNumber(number);
        System.out.println(tempVo.toString());
        System.out.println();

        //View에서 사용할 녀석들 넣기
        Map<String, Object> model = new HashMap<>();
        
       
        File dirFile = new File(tempVo.getTp_image_path());
        File[] files = dirFile.listFiles();
        for (File tempFile : files) {
            if (tempFile.isFile()) {
                String tempPath = tempFile.getParent();
                String tempFileName = tempFile.getName();
                System.out.println(tempPath + "\\" + tempFileName);
                int lastDot = tempFileName.lastIndexOf('.');
                System.out.println(tempFileName.substring(0, lastDot));

                if (tempFileName.substring(0, lastDot).equals("profile")) {
                    model.put("profile", "/LocalImage/tutorProp/"+num+"/"+tempFileName);
                    System.out.println(model.get("profile"));
                }
                if (tempFileName.substring(0, lastDot).equals("certification")) {
                    model.put("certification", "/LocalImage/tutorProp/"+num+"/"+tempFileName);
                    System.out.println(model.get("certification"));
                }
                for (int i = 0; i < files.length; i++) {
                    if (tempFileName.substring(0, lastDot).equals("add" + i)) {
                        model.put("add" + i, "/LocalImage/tutorProp/"+num+"/"+tempFileName);
                        System.out.println(model.get("add"+i));
                    }
                }
            }
        }     
        model.put("count", count);
        model.put("tutorPropList", list);
        model.put("pageNum", pageNum);
        model.put("search_text", search_text);
        model.put("search_type", search_type);
        model.put("bp", paging);
        model.put("tempVO", tempVo);
        modelAndView.addAllObjects(model);


        modelAndView.setViewName("admin/tutorProp");
        return modelAndView;
    }


    public void setTutor_propSearchService(Tutor_PropSearchService tutor_propSearchService) {
        this.tutor_propSearchService = tutor_propSearchService;
    }
}
