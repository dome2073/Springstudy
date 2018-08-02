package com.bitcamp.mvc0730;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	//로그인 폼으로 이동해야하니 GET으로 
	@RequestMapping(value="/member/login/login", method =RequestMethod.GET)
	public String loginForm() {
		
		return "member/loginform";
		
	}
	
	//로그인 폼에서 submit(method = post) 했을 경우 
	//로그인 폼에서 받아온 데이터를 가져옴 - @RequestParam("id")
	//받아온 데이터로 세션을 생성 하기 - request.getSession(false).setAttribute("logininfo", id);
	
	@RequestMapping(value="/member/login/login", method =RequestMethod.POST)
	public String login(@RequestParam("id")String id,HttpServletRequest request) {
		
		request.getSession(false).setAttribute("logininfo", id);
		
		return "member/login";
	}
	
	@RequestMapping(value="/member/mypage/mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	//주문
	@RequestMapping(value="/member/order/order")
	public String order() {
		return "member/mypage";
	}
	
	@RequestMapping(value="/member/service/qna")
	public String qna() {
		
		//- 예외처리예제 - ExceptionHandler 
		//강제 예외 발생을 위해 null 값
		
		String str = null;
		System.out.println(str.charAt(0));
		
		return "member/mypage";
	}
	
	//예외처리 뷰 실행
	//@ExceptionHandler(class) - 클래스를 명시
	//만약 예외처리를 해주지않고 null값이 들어올경우 500번 에러발생
	@ExceptionHandler(NullPointerException.class)
	public String NullpointerException(NullPointerException e){
		
		return "error/nullPointer";

	}
}
