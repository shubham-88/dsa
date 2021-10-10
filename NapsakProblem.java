package programs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NapsakProblem {

	public static void main(String[] args) {
		//Maximizing profit
		
		int n = 4; //items
		int m = 8; // bagSize

		int w[] = { 0, 2, 3, 4, 5 }; //item weight
		int p[] = { 0, 1, 2, 5, 6 }; //item price

		System.out.println(calculateMaximumPrice(n, m, p, w));
/*		
   wt/m->  012345678
   
       i/n	
w0	p0	0  000000000
w1	p1	1  000000000
w2	p2	2  000000000
w3	p3	3  000000000
w4	p4	4  000000000
		
*/

	}

	private static int calculateMaximumPrice(int n, int m, int[] p, int[] w) {
		int nm[][] = new int[n + 1][m + 1];
		for (int i = 0; i < nm.length; i++) {
			Arrays.fill(nm[i], 0);
		}

		for (int i = 1; i <= n; i++) {
			for (int wt = 1; wt <= m; wt++) {
				int res = Math.max(nm[i - 1][wt], ((wt - w[i] >= 0) ? nm[i - 1][wt - w[i]] + p[i] : 0));
				nm[i][wt] = res;
			}
		}
		printSelectedPrice(nm, p, nm[n][m]);
		return nm[n][m];
	}

	private static void printSelectedPrice(int nm[][], int[] p, int remainingPrice) {
		Map<Integer, List<Integer>> matrix = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < nm.length; i++) {
			matrix.put(i, IntStream.of(nm[i]).boxed().collect(Collectors.toList()));
		}

		while (remainingPrice != 0) {
			int pIndex = getFirstIndexOf(matrix, remainingPrice);
			remainingPrice = remainingPrice - p[pIndex];
			System.out.println(p[pIndex]);
		}
	}

	private static int getFirstIndexOf(Map<Integer, List<Integer>> matrix, final int maxPrice) {
		return matrix.entrySet().stream().filter(e -> e.getValue().contains(maxPrice)).mapToInt(i -> i.getKey()).min()
				.orElseThrow();
	}

}
