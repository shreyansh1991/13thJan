package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream5 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Shreyansh");
		list.add("Abhishek");
		list.add("Chetan");
		list.add("Dharmendra");
		list.add("Pavan");
		
		String firstMatchedName = list.stream()
				.filter((s) -> s.startsWith("S"))
				.findAny().get();
		System.out.println(firstMatchedName);
		
	}

}




