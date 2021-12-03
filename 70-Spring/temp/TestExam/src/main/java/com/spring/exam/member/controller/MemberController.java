package com.spring.exam.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.exam.member.service.MemberService;
import com.spring.exam.member.service.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberSerivce;
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public String signup(MemberVO vo) {
		memberSerivce.insertMember(vo);
		
		return "login.jsp";
	}
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signupView() {
		return "singup.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView() {
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(MemberVO vo, Model model) {
		MemberVO loginMember = memberSerivce.selectOneMember(vo.getId());
		if (loginMember != null) {
			model.addAttribute("loginMember", loginMember);
			return "loginSuccess.jsp";
		} else {
			return "loginFail.jsp";
		}
	}
}
