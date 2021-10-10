package programs;

public class LCS {

	static int[][] table;

	public static void main(String arr[]) {

		String s1 = "araaci";
		String s2 = new StringBuilder("araaci").reverse().toString();
		int lcs = lcsAlgo(s1, s2);
		printLCSString(s1, s2, lcs);
		LCS_PD_Print(s1);
	}

	private static void printLCSString(String s1, String s2, int lcs) {
		char res[] = new char[lcs];
		int m = s1.length();
		int n = s2.length();

		while (m > 0 && n > 0) {
			if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
				res[lcs - 1] = s1.charAt(m - 1);
				m--;
				n--;
				lcs--;
			} else if (table[m - 1][n] > table[m][n - 1]) {
				m--;
			} else {
				n--;
			}
		}
		new String(res).chars().mapToObj(c -> (char) c).forEach(System.out::print);
	}

	private static int lcsAlgo(String x, String y) {
		int m = x.length();
		int n = y.length();
		table = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					table[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					table[i][j] = 1 + table[i - 1][j - 1];
				} else {
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
				}
			}
		}
		return table[m][n];
	}

	/***
	 * WIll search for a continuous plaindrom
	 * 
	 * @example input "abaac" output "aba"
	 * @param input
	 */
	public static void LCS_PD_Print(String input) {

		int n = input.length();
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				String substr = input.substring(i, j + 1);
				if (isPD2(substr)) {
					System.out.println("PD : " + substr);
				}
			}
		}

	}

	public static boolean isPD(String input) {
		if (input == null) {
			return false;
		}
		if (input.length() > 1) {
			return input.equals(new StringBuilder(input).reverse().toString());
		} else {
			return true;
		}
	}

	public static boolean isPD2(String input) {
		if (input == null) {
			return false;
		}
		int i = 0;
		int j = input.length() - 1;

		while (i < j) {
			if (input.charAt(i) != input.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;

	}

}
