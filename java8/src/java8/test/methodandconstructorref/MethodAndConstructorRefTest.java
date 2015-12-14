package java8.test.methodandconstructorref;

import java8.test.Converter;

public class MethodAndConstructorRefTest {
	/*
	 * Method and Constructor ReferencesThe
	 */

	public static void main(String[] args) {
		/*
		 * above example code can be further simplified by utilizing static
		 * method references
		 */

		Converter<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted); // 123

		/*
		 * Java 8 enables you to pass references of methods or constructors via
		 * the :: keyword. The above example shows how to reference a static
		 * method. But we can also reference object methods:
		 */

		Something something = new Something();
		Converter<String, String> converter1 = something::startsWith;
		String converted1 = converter1.convert("Java");
		System.out.println(converted1); // "J"

		/*
		 * Let's see how the :: keyword works for constructors. First we define
		 * an example bean with different constructors:
		 */
		/*
		 * Next we specify a person factory interface to be used for creating
		 * new persons: Instead of implementing the factory manually, we glue
		 * everything together via constructor references:
		 */
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", "Parker");
		/*
		 * We create a reference to the Person constructor via Person::new. The
		 * Java compiler automatically chooses the right constructor by matching
		 * the signature of PersonFactory.create.
		 */
	}

}
