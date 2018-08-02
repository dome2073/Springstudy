package member.dao;

import member.model.Member;

public class MemberDao implements Dao{
	
	//메서드구현
	public void insert(Member member) {
		// TODO Auto-generated method stub
		System.out.println("MybatisDao");
		System.out.println("회원 정보가 입력되었습니다.");
		System.out.println(member);
	}
	
	public void delete(String id) {
		// TODO Auto-generated method stub
		System.out.println("MybatisDao");
		System.out.println(id + " : 회원 데이터가 삭제되었습니다.");
		System.out.println(id);
	}
	
}
