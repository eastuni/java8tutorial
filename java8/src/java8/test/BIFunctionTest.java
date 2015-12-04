package java8.test;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BIFunctionTest {

	public static void main(String[] args) {

		/*
		 * Predicates - Predicates are boolean-valued functions of one argument.
		 * The interface contains various default methods for composing
		 * predicates to complex logical terms (and, or, negate)
		 */
		Predicate<String> predicate = (s) -> s.length() > 0;
		System.out.println(predicate.test("Fee"));
		System.out.println(predicate.negate().test("Fee"));

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		System.out.println(nonNull.test(null));
		System.out.println(isNull.test(null));

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();

		/*
		 * Functions - Functions accept one argument and produce a result.
		 * Default methods can be used to chain multiple functions together
		 * (compose, andThen).
		 */
		Function<String, Integer> toInteger = Integer::valueOf;
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		System.out.println(backToString.apply("123")); // "123"
		System.out.println(toInteger.apply("123") + 1); // "123"

		/*
		 * Suppliers - Suppliers produce a result of a given generic type.
		 * Unlike Functions, Suppliers don't accept arguments.
		 */
		Supplier<Person> personSupplier = Person::new;
		Person person = personSupplier.get(); // new Person
		person.name = "Tester";
		System.out.println(person);

		/*
		 * Consumers - Consumers represents operations to be performed on a
		 * single input argument.
		 */
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.name);
		greeter.accept(new Person("Luke"));

		/*
		 * Optionals - Optionals are not functional interfaces, instead it's a
		 * nifty utility to prevent NullPointerException. It's an important
		 * concept for the next section, so let's have a quick look at how
		 * Optionals work. Optional is a simple container for a value which may
		 * be null or non-null. Think of a method which may return a non-null
		 * result but sometimes return nothing. Instead of returning null you
		 * return an Optional in Java 8.
		 */

		// Optional<String> optional = Optional.ofNullable(null);
		Optional<String> optional = Optional.of("bam");

		System.out.println(optional.isPresent()); // true
		System.out.println(optional.get()); // "bam"
		System.out.println(optional.orElse("fallback")); // "bam"

		optional.ifPresent((s) -> System.out.println(s.charAt(0))); // "b"

		/*
		 * We create a reference to the Person constructor via Person::new. The
		 * Java compiler automatically chooses the right constructor by matching
		 * the signature of PersonFactory.create.
		 */
		
		

	}

}
