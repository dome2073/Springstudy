package com.bitcamp.mvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/simple")
public class SimpleConverterController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String simpleForm() {
		return "/form";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	// 메서드의 리턴값을 응답데이터로 사용
	//요청정보에서 들어온 파라미터 정보들을 변환해서 body에 넣음. 우린 응답타입이 String,
	@ResponseBody
	public String simple(@RequestBody String body){
		//@RequsetBody : 요청 http데이터를 String body로 전달
		return body;
	}
}
