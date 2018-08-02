package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect {
	//실행해야할 메서드의 정보가 들어있는 ProceedingJoinPoint 객체를 저장
	public Object meaure(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//공통 코드 : 시작시간
		long startTime = System.nanoTime();
		
		try {
			//핵심코드 실행
			Object result = joinPoint.proceed(); //핵심 로직의 메서드 실행 요청
			return result;			
		}finally {
			long endTime = System.nanoTime();
			Signature signature = joinPoint.getSignature();
			
			System.out.printf("%s.%s 실행시간 : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),
					signature.getName(), (endTime - startTime));
		}
		//공통코드 : 종료시간
	}
}
