package dsa;

import java.util.ArrayList;
import java.util.List;

public class FindNthPrimeNumber {

	public static void main(String[] args) {

		int n = 5;
		List<Integer> res = new ArrayList<Integer>();
		if (n == 0 || n == 1) {
			System.out.println(false);
		}
		int max = 1000005;
		boolean[] data = new boolean[max];

		for (int i = 0; i < max; i++) {
			data[i] = true;
		}

		for (int i = 2; i * i < max; i++) {

			if (data[i] == true) {
				// mark all multipliar of i
				for (int x = i * i; x < max; x += i) {
					data[x] = false;
				}
			}
		}

		for (int i = 2; i < max; i++) {
			if (data[i] == true) {
				res.add(i);
			}
		}

		System.out.println(res.get(n - 1));
	}

}
