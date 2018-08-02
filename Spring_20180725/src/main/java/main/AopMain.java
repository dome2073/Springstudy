package main;

import org.springframework.context.support.GenericXmlApplicationContext;

import test.Calcurator;

public class AopMain {
	
	public static void main(String args[]) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopPojo.xml");
		
		Calcurator c1 = ctx.getBean("RecCal",Calcurator.class);
		
		long f1 = c1.factorial(10);
		System.out.println("RecCalcurator.factorial(10) : " + f1);
		
		System.out.println("---------------------------");
		
		Calcurator c2 = ctx.getBean("CalImp", Calcurator.class);
		
		long f2 = c2.factorial(10);
		System.out.println("CalcuratorImp.factorial(10) : " + f2);
		;
		
	}
}
