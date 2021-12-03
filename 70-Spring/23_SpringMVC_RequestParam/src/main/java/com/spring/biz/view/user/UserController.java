package com.spring.biz.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.user.UserVO;
import com.spring.biz.user.impl.UserDAO;

@Controller
public class UserController {

	//@RequestMapping(value = "/login.do", method = RequestMethod.POST) // login.jsp 에서 폼태그 액션이랑 맞아야한다.
	@PostMapping("/login.do") // 오라클 4.3 버전부터 사용가능 + <mvc:annotation-driven></mvc:annotation-driven> 설정 추가
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println(">>>> 로그인 처리 - login()");
		System.out.println("vo : " + vo);

		UserVO user = userDAO.getUser(vo);
		System.out.println("user : " + user);
		
		if (user != null) {
			System.out.println(">> 로그인 성공!!!");
			return ("getBoardList.do");
		} else {
			System.out.println(">> 로그인 실패 ~~");
			return ("login.jsp");
		}

	}
	
	// @ModelAttribute : 모델의 속성값으로 저장(속성명 별도 지정)
	// 별도 명칭 부여 안하면 <데이터타입>의 첫글자 소문자로 작성된 명칭 ex) UserVO vo 에서 uservo 이렇게
	// @ModelAttribute UserVo --> 속성명 userVO 형태
	// @ModelAttribute("user") UserVO --> 속성명  user 사용
	
	//@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	@GetMapping("/login.do")
	public String loginView(@ModelAttribute("user") UserVO vo) { 
		System.out.println(">>> 로그인 화면 이동 - loginView()");
		vo.setId("test");
		vo.setPassword("test999");
		return "login.jsp";
	}
	
	
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println(">>> 로그아웃 처리");
		session.invalidate();
		return "login.jsp";
	}


}
