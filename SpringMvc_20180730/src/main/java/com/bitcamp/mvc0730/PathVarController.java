package com.bitcamp.mvc0730;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//PathVariable 사용 예제
//http://localhost/mvc0730/mypage/cool  == http://localhost/mvc0730/mypage?id=cool
public class PathVarController {
	
	@RequestMapping("/mypage/{id}") 
	// http://localhost:8080/mvc0730/mypage/cool 
	//사용자 아이디에 따른 경로로 이동
	public String getMypage(@PathVariable("id") String userid, Model model) {
		
		System.out.println(userid);
		
		model.addAttribute("userid", userid);
		return "mypage";
	}
}
