package java8.test.methodandconstructorref;

interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName);
}