package com.zest.web.client.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class TutorPageController {

    @RequestMapping(value = "/tutorPage")
    public ModelAndView viewTutorPageController(ModelAndView modelAndView) {

        modelAndView.setViewName("common/myPage");
        //튜터페이지인지 확인시켜주는 녀석
        modelAndView.addObject("pageType","tutor");
        return modelAndView;
    }
}
