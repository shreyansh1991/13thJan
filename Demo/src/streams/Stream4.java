package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream4 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Shreyansh");
		list.add("Abhishek");
		list.add("Chetan");
		list.add("Dharmendra");
		list.add("Pavan");
		
		Stream<String> stream=list.stream();
	//	stream.map(s->s.toUpperCase()).forEach(System.out::println);
		
	//	list.stream().sorted().map(s->s.intValue()).forEach(System.out::println);
		
		list.stream().filter(s -> s.startsWith("A"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
		
	}

}



