package com.bitcamp.mvc0726;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 지정
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		ModelAndView modelAndView = new ModelAndView();
		//응답할 뷰 지정
		modelAndView.setViewName("hello"); //응답하고자 하는 뷰이름 지정 //hello 뷰를 찾고
		// 결과 데이터 저장
		modelAndView.addObject("greeting",getGreeting()); //전달해야되는 데이터를 담음 //데이터를 담아서 줌
		
		return modelAndView;
	}

	private Object getGreeting() {
		// TODO Auto-generated method stub
		return "안녕하세요";
	}
}
