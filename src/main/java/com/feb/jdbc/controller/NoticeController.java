package com.feb.jdbc.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.jdbc.entity.Notice;
import com.feb.jdbc.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;

	@PostMapping("/notice.do")
	public ModelAndView insert(@RequestParam HashMap<String, String> params,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.insertNotice(params);
		
		mv.addObject("resultCode", result);
		if (result == 1) {
			mv.addObject("resultMsg", "게시글 작 성공");
		} else {
			mv.addObject("resultMsg", "게시글 작 실패");
		}
		mv.setViewName("hello");
		return mv;
	}
	
	@PatchMapping("/notice.do")
	public ModelAndView update(@RequestParam HashMap<String, String> params,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.updateNotice(params);
		
		mv.addObject("resultCode", result);
		if (result == 1) {
			mv.addObject("resultMsg","변경성공");
		} else {
			mv.addObject("resultMsg", "변경실패");
		}
		mv.setViewName("hello");
		return mv;
	}
	
	
	@GetMapping("/notice.do")
	public ModelAndView list(@RequestParam HashMap<String,String> params, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		ArrayList<Notice> result = noticeService.selectNoticeList(params);
		System.out.println(result.size());
		System.out.println(result.toString());
		mv.addObject("NoticeList",result);
		mv.setViewName("hello");
		return mv;
	}
	
	@DeleteMapping("/notice.do")
	public ModelAndView remove(@RequestParam HashMap<String, String> params, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.deleteNotice(params);
		if(result == 1) {
			mv.addObject("resultMsg","삭제 성공");
		}else {
			mv.addObject("resultMsg","삭제 실패");
		}
		mv.setViewName("hello");
		return mv;
		
	}
	

}





