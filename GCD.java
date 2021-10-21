package dsa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GCD {

	// greatest common devident
	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	public static void main(String arr[]) {
		int nums[] = { -1 };
		int d = 2;

		// For rotating an array
		rotate0(nums, d);
		IntStream.of(nums).forEach(i -> System.out.print(" " + i));
	}

	public static void rotate0(int[] nums, int k) {
		if (nums.length == 1 || nums.length == k || k == 0) {
			return;
		}

		if (nums.length < k) {
			k = k % nums.length;
		}

		int newArr[] = new int[k];
		int maxLen = nums.length;

		int k_index = 0;
		for (int i = maxLen - k; i < maxLen; i++) {
			newArr[k_index++] = nums[i];
		}

		int[] finalArr = new int[maxLen];
		for (int i = 0; i < maxLen; i++) {
			if (i < newArr.length)
				finalArr[i] = newArr[i];
			else
				finalArr[i] = nums[i - k];
		}

		for (int i = 0; i < maxLen; i++) {
			nums[i] = finalArr[i];
		}
	}

	// Juggling algo.
	public static void rotate(int[] nums, int k) {
		int gcd = gcd(nums.length, k);
		for (int set = 0; set < gcd; set++) {
			int start = set;
			int last = 0;
			while (start < nums.length) {
				int tempthis = nums[start];
				nums[start] = last;
				last = tempthis;
				start = start + gcd;
			}
			nums[set] = last;

		}

	}

	public static void roateTest(int[] nums, int k) {
		List<Integer> l = IntStream.of(nums).mapToObj(i -> i).collect(Collectors.toList());
		while (k > 0) {
			l.add(0, l.remove(l.size() - 1));
			k--;
		}
		System.out.println();
		l.forEach(System.out::print);
	}

	public static void roateTestLeft(int[] nums, int k) {
		List<Integer> l = IntStream.of(nums).mapToObj(i -> i).collect(Collectors.toList());
		while (k > 0) {
			l.add(l.size() - 1, l.remove(0));
			k--;
		}
		System.out.println();
		l.forEach(System.out::print);
	}

}
