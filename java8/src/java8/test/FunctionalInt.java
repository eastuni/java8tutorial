package java8.test;

public class FunctionalInt {

	public static void main(String[] args) {
		Converter<String, Integer> converter= (from) -> Integer.valueOf(from);
		Integer converted = converter.convert("1234");
		System.out.println(converted);
		
//		Converter<String, Integer> converter= (from) -> {Integer d=Integer.valueOf(from);return d;};

	}

}
