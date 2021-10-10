package programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintCombinationOfArray {

	public static void main(String[] arr) {
		prinCombination();
	}

	public static void prinCombination() {

		List<String> list1 = Arrays.asList("a", "b", "c");
		List<String> list2 = Arrays.asList("d", "e", "f");
		List<String> list3 = Arrays.asList("g", "h", "i");
		List<List<String>> data = new ArrayList<List<String>>();
		data.add(list1);
		data.add(list2);
		data.add(list3);
		List<String> result = new ArrayList<String>();
		Queue<String> q = new LinkedList<String>();
		q.addAll(list1);
		while (!q.isEmpty()) {
			String item = q.poll();
			if (item.length() == data.size()) {
				result.add(item);
			} else {
				List<String> dataItem = data.get(item.length());
				for (String string : dataItem) {
					q.add(item.concat(string));
				}
			}
		}
		System.out.println(result);
	}

}
