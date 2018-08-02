package com.bitcamp.mvc.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="message-list")
public class GuestMessageList {
	//응답으로 처리하겠다.
	@XmlElement(name = "massage")//반환타입지정
	private List<GuestMessage> message;
	
	public GuestMessageList() {
		
	}

	public GuestMessageList(List<GuestMessage> message) {
		super();
		this.message = message;
	}


	public List<GuestMessage> getMessage() {
		return message;
	}

	public void setMessage(List<GuestMessage> message) {
		this.message = message;
	}
	
	
}
