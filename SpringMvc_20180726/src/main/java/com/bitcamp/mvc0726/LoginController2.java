package com.bitcamp.mvc0726;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping(value="/login",method=RequestMethod.GET) 중복이므로 하나로 생략가능
//둘이 같은 요청이지만 다른방식이므로 다르게 처리
@RequestMapping("/login")
public class LoginController2 {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginForm() {
		return "loginform";
	}
	//loginform 데이터가 일로들어옴 post.
	//요청하게되면 d.s서블릿이 요청처리(/login) 할때 매개변수에있는 HttpServletRequest를 같이 보내줌
	//나중에는 애너테이션으로 다 대체가능
	
	
	/*방법 1
	 * @RequestMapping(method=RequestMethod.POST)
	public String proocessLogin(HttpServletRequest request) {
		
		//JSP에서 썻던 방식.
		//1.request 객체를 이용한 데이터받기
		// : 메서드의 매개변수에 HttpServletRequest 매개변수로 선언
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("폼에서 전송된 데이터 :"+ id + "비밀번호:" +pw);
		
		return "loginok";
	}*/
	
	//방법 2 
	//RequestParam을 통해서 값을 받아오기
	//단점 : 여러개의 값을 받아오기 불편하다
	/*@RequestMapping(method=RequestMethod.POST)
	public String proocessLogin(@RequestParam("id") String userid,
			@RequestParam("pw")String userpw) {
		
		System.out.println("폼에서 전송된 데이터 :"+ userid + "비밀번호:" +userpw);
		
		return "loginok";
	}*/
	
	//방법 3 자바 빈 객체 사용
	@RequestMapping(method=RequestMethod.POST)
	public String proocessLogin(LoginInfo info,Model model) {
		
		System.out.println("폼에서 전송된 데이터 :"+ info.getId() + "비밀번호:" + info.getPw());
		System.out.println("데이터 info" + info);
		
		model.addAttribute("id",info.getId()); //지정한 view로 데이터를 보냄 - view에서는 EL태그를 통해서 표현 'id'
		model.addAttribute("pw",info.getPw()); //지정한 view로 데이터를 보냄 - view에서는 EL태그를 통해서 표현 'pw'
		model.addAttribute("Userinfo",info); //지정한 view로 데이터를 보냄 - view에서는 EL태그를 통해서 표현 'Userinfo'
	
		
		
		return "loginok";
	}
}
