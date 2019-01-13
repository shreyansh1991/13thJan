package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream3 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(21);
		list.add(13);
		list.add(14);
		list.add(54);
		list.add(69);
		list.add(16);
		
		list.add(11);
		list.add(91);
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		
	//	list.stream().sorted().map(s->s.intValue()).forEach(System.out::println);
	}

}
