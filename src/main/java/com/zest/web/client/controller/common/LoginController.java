package com.zest.web.client.controller.common;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zest.web.client.model.ClientVO;
import com.zest.web.client.service.client.ClientSearchService;

//회원가입 페이지 컨트롤러
@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ClientSearchService clientSearchService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// 로그인 페이지
	@RequestMapping(value = "/common/loginPage")
	public ModelAndView viewMainPage() {
		logger.info("...ing-jjj");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("common/loginPage");
		return modelAndView;
	}

	// 로그인
	@RequestMapping(value = "/common/loginPage", method = RequestMethod.POST)
	public ModelAndView Login(ClientVO clientVO, ModelAndView modelAndView, HttpSession session) {
		logger.info("..ing");		
		ClientVO vo = clientSearchService.getClient(clientVO);		
		//이메일이 존재하지 않을시
		if(vo == null) {
			modelAndView.setViewName("common/loginPage");
			modelAndView.addObject("result", "noEmail");
			return modelAndView;
		}
		//비밀번호가 같지 않으면 
		if(!passwordEncoder.matches(clientVO.getCl_pass(),vo.getCl_pass())) {
			modelAndView.setViewName("common/loginPage");
			modelAndView.addObject("result", "false");
			return modelAndView;
		}
		//모두 일치하면
		else {
			modelAndView.setViewName("common/loginPage");
			modelAndView.addObject("result", "success");
			//해당 사용자 세션에 저장
			session.setAttribute("client", vo);
			return modelAndView;
		}		
	}

	public ClientSearchService getClientSearchService() {
		return clientSearchService;
	}

	public void setClientSearchService(ClientSearchService clientSearchService) {
		this.clientSearchService = clientSearchService;
	}

	public BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
	
}
