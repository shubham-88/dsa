package programs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinimumCoinsProblem {

	public static void main(String[] args) {

		int total = 18;
		int coins[] = { 7, 5, 1 };
		int table[] = new int[total + 1];
		Arrays.fill(table, -1);
		table[0] = 0;
		System.out.println(findMinumCoins1(coins, total));
		System.out.println(findMinumCoins2(coins, total, table));
		System.out.println();
		IntStream.of(table).forEach(i -> System.out.print(i + " "));

	}

	private static int findMinumCoins1(int[] coins, int total) {
		if (total == 0) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= total) {
				int subRes = findMinumCoins1(coins, total - coins[i]);
				// Importent condition: we are checking if we can further minimize the result
				// with this subProblemRes, only then we are accepting this result.
				if (subRes != Integer.MAX_VALUE && subRes + 1 < result) {
					result = subRes + 1;
				}
			}
		}
		return result;
	}

	private static int findMinumCoins2(int[] coins, int total, int[] table) {
		if (total == 0) {
			return 0;
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= total) {
				int subRes = 0;
				if (total - coins[i] >= 0 && table[total - coins[i]] != -1) {
					subRes = total - coins[i];
				} else {
					subRes = findMinumCoins2(coins, total - coins[i], table);
				}
				// Importent condition: we are checking if we can further minimize the result
				// with this subProblemRes, only then we are accepting this result.
				if (subRes != Integer.MAX_VALUE && subRes + 1 < result) {
					result = subRes + 1;
				}
			}
		}
		return table[total] = result;
	}

}
