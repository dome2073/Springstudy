package member.dao;

import member.model.Member;

public interface Dao {
	
	//반환하는 메서드
	void insert(Member member);
	void delete(String id);
	
}
