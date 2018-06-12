package com.zest.web.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainPageController {

	// 관리자 메인 페이지
	@RequestMapping("/admin/main")
	public String viewAdminMainPage(HttpSession session) {
		if(session.getAttribute("admin") == null) {
			session.invalidate();
		}
		return "/admin/adminPageMain";
	}
}
