package vol1.kitec.ch7.study3_3.learningtest.spring.pointcut;

public class Target implements TargetInterface {

	public void hello() {
	}

	public void hello(String a) {
	}

	public int minus(int a, int b) throws RuntimeException {
		return 0;
	}

	public int plus(int a, int b) {
		return 0;
	}
	
	public void method() {}

}