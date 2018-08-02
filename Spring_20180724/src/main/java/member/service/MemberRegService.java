package member.service;

import org.springframework.beans.factory.annotation.Autowired;

import member.dao.MemberDao;
import member.model.Member;

public class MemberRegService {
	
	MemberDao dao;
	//dao가 필요
	
	
	// 의존주입
	// 직접생성 x, 생성자를 통해서
	@Autowired
	public MemberRegService(MemberDao dao) {
		this.dao = dao;
	}
	
	public void insertMember(Member member) {
		dao.insert(member);
	}
}
