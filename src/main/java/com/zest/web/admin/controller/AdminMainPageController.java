package com.zest.web.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminMainPageController {

	@RequestMapping("/admin/main")
	public String viewAdminMainPage() {
		
		return "/admin/adminPageMain";
	}
}
