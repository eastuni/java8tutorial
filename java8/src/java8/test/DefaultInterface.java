package java8.test;

public interface DefaultInterface {

	double cal(int a);
	default double sqrt(int a){
		return Math.sqrt(a);
	}
}
