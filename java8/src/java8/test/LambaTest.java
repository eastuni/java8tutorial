package java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambaTest {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("aca","dbb","ecc","bdd");
		
		Collections.sort(names,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareTo(o2);
			}
			
		});
		
		System.out.println(names);
		
		List<String> names2 = Arrays.asList("aca","dbb","ecc","bdd");
		Collections.sort(names2,(String a, String b)->{return b.compareTo(a);});
		System.out.println(names2);
		
		Collections.sort(names2,(String a, String b)-> a.compareTo(b));
		System.out.println(names2);

		Collections.sort(names2,(a, b)-> a.compareTo(b));
		System.out.println(names2);
		
	}
	
	
}
