package com.bitcamp.mvc0726;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 컨트롤러등록
@Controller
public class IndexController {
	
	//메서드등록
	@RequestMapping("/")
	public String getIndex() {
		
		return "index";
	}
}
