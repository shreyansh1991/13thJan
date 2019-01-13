package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			list.add(i);
		}
		Stream<Integer> stream = list.stream();
		Set set = stream.filter(i -> i > 2 && i < 6).collect(Collectors.toSet());
		System.out.println(set);
	}

}
