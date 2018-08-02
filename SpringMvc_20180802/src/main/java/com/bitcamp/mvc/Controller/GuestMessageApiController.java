package com.bitcamp.mvc.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mvc.model.GuestMessage;
import com.bitcamp.mvc.model.GuestMessageList;

@Controller
public class GuestMessageApiController {
	
	//반환하고자 하는것 = xml로 변환된 객체 (응답)
	@RequestMapping("/guestMessage/list.xml")
	@ResponseBody
	public GuestMessageList listXml() {
		//처리 
		//응답해야할 데이터
		List<GuestMessage> message = new ArrayList<GuestMessage>();
		//반환해야할 메세지를 추가해줌 (데이터를 추가해줌
		message.add(new GuestMessage(1,"안녕하세요",new Date()));
		message.add(new GuestMessage(2,"문의",new Date()));
		message.add(new GuestMessage(3,"긴급",new Date()));
		
		return new GuestMessageList(message);
	}
	
	//반환하고자 하는것 = xml로 변환된 객체 (응답)
		@RequestMapping("/guestMessage/list.json")
		@ResponseBody
		public GuestMessageList listJson() {
			//처리 
			//응답해야할 데이터
			List<GuestMessage> message = new ArrayList<GuestMessage>();
			//반환해야할 메세지를 추가해줌 (데이터를 추가해줌
			message.add(new GuestMessage(1,"안녕하세요",new Date()));
			message.add(new GuestMessage(2,"문의",new Date()));
			message.add(new GuestMessage(3,"긴급",new Date()));
			
			return new GuestMessageList(message);
		}
}
