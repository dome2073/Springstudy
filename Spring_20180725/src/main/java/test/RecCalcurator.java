package test;

public class RecCalcurator implements Calcurator {

	
	public long factorial(long num) {
		//재귀함수사용
		if(num == 0) {
			return 1;
		}else {
			return num * factorial(num-1);
		}
	}

}
