package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.model.Member;
import member.service.MemberDeleteService;
import member.service.MemberRegService;

public class SpringMain {

	// Spring 컨테이너 생성
	private static GenericXmlApplicationContext ctx = null;

	public static void main(String[] args) {

		ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

		MemberRegService regService = null; // new MemberRegService();
		
		regService = ctx.getBean("memberRegSvc", MemberRegService.class);
		
		regService.insertMember(new Member());
		
		System.out.println("---------------------------");
		
		MemberDeleteService deleteService = ctx.getBean("memberDeleteSvc", MemberDeleteService.class);

		deleteService.deleteMember("cool");
		
		MemberRegService regService2 = ctx.getBean("memberRegSvc",MemberRegService.class);
		
		System.out.println("memberRegSvc비교 : "+(regService == regService2)); //같은주소 = 같은객체 = 기존에 만든것으로 만들었다 = 싱글톤 처리(default
		
		MemberDeleteService deleteService2 = ctx.getBean("memberDeleteSvc", MemberDeleteService.class);
		
		System.out.println("deleteService비교 : "+(deleteService == deleteService2)); //다른주소 = 다른객체 = 요청할때마다 새로운 빈 객체 생성 = prototype
		
		
		
		
		
		
		
	}

}
