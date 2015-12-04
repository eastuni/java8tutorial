package java8.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class QuickSort {

	public static <T> List<T> Quicksort(List<T> v, BiFunction<T, T, Integer> comparer) {
		if (v.size() < 2)
			return v;
		T pivot = v.get(v.size() / 2);
		List<T> l = new LinkedList<T>(
				Quicksort(v.stream().filter(x -> comparer.apply(x, pivot) < 0).collect(Collectors.toList()), comparer));
		l.addAll(v.stream().filter(x -> comparer.apply(x, pivot) == 0).collect(Collectors.toList()));
		l.addAll(
				Quicksort(v.stream().filter(x -> comparer.apply(x, pivot) > 0).collect(Collectors.toList()), comparer));
		return l;
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("bsdf","dlasdf","asldfj","radfssa","qadsfs","cwerw","zasdf","eadsf","gasdf");
		BiFunction<String, String, Integer> comparer = (a,b)->a.compareTo(b);
		List<String> quicksort = Quicksort(list, comparer );
		System.out.println(quicksort);
	}

}
