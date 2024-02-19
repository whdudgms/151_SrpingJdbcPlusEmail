package com.feb.jdbc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/loginPage.do")
	public String loginForm() {
		return "login";
	}

	
	@PostMapping("/login.do")
	public ModelAndView login(@RequestParam HashMap<String,String> params, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		boolean result = loginService.login(params);
		if(result) {
			mv.addObject("resultMsg","로그 성공.");
			mv.addObject("resultCode","loginOk");
		}else{
			
			mv.addObject("resutlMsg","로그인 실패.");
			mv.addObject("resultCode","loginFail");
		}
		
		System.out.println(mv.getViewName());
		System.out.println(mv.getViewName());
		System.out.println(mv.getViewName());
		
		return mv;
		
	}
}
