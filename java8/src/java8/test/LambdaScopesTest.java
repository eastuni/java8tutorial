package java8.test;

public class LambdaScopesTest {

	public static void main(String[] args) {
		/*
		 * Lambda Scopes - Accessing outer scope variables from lambda
		 * expressions is very similar to anonymous objects. You can access
		 * final variables from the local outer scope as well as instance fields
		 * and static variables.
		 */

		/*
		 * Accessing local variables - We can read final local variables from
		 * the outer scope of lambda expressions:
		 */

		final int num = 1;
		Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

		stringConverter.convert(2); // 3
		/*
		 * But different to anonymous objects the variable num does not have to
		 * be declared final. This code is also valid: However num must be
		 * implicitly final for the code to compile. The following code does not
		 * compile: Writing to num from within the lambda expression is also
		 * prohibited.
		 */

		/*
		 * Accessing fields and static variables - In constrast to local
		 * variables we have both read and write access to instance fields and
		 * static variables from within lambda expressions. This behaviour is
		 * well known from anonymous objects.
		 */
		// see testScopes();

		/*
		 * Accessing Default Interface Methods - Remember the formula example from
		 * the first section? Interface Formula defines a default method sqrt
		 * which can be accessed from each formula instance including anonymous
		 * objects. This does not work with lambda expressions. Default methods
		 * cannot be accessed from within lambda expressions. The following code
		 * does not compile:
		 */
		
//		Formula formula = (a) -> sqrt( a * 100);


	}

	static int outerStaticNum;
	int outerNum;

	void testScopes() {
		Converter<Integer, String> stringConverter1 = (from) -> {
			outerNum = 23;
			return String.valueOf(from);
		};

		Converter<Integer, String> stringConverter2 = (from) -> {
			outerStaticNum = 72;
			return String.valueOf(from);
		};
	}

}
