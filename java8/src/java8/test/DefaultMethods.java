package java8.test;

public class DefaultMethods {

	public static void main(String[] args){
		DefaultInterface di = new DefaultInterface() {
			
			@Override
			public double cal(int a) {
				return Math.sqrt(a*100);
			}
		};
		
		System.out.println(di.cal(100));
		System.out.println(di.sqrt(16));
		
	}
	
}
