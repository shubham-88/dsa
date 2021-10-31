package dsa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedChar {

	public static void main(String[] args) {

		String str = "hello";
		str.chars().mapToObj(c -> (char) c).forEach(c -> System.out.println(c));
		str.codePoints().forEach(c -> System.out.println(c));

		// problem code
		Map<String, Long> dataMap = str.chars().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

		Map.Entry<String, Long> result = dataMap.entrySet().stream().filter(e -> e.getValue() == 1L).findFirst()
				.orElse(null);

		Map<Character, Long> res = str.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(res);

		if (result == null) {
			System.out.println("None");
		} else {
			System.out.println(result.getKey());
		}

	}

}
