package programs;

public class NthPrimeNumber {

	public static void main(String[] args) {

		int n = 40076;
		System.out.println(isPrime(4));
		findNthPrimeNumber(n);

	}

	private static void findNthPrimeNumber(int n) {
		int j = 1;
		int count = 1;
		while (true) {
			if (isPrime(j)) {
				if (count == n) {
					System.out.println(count + " :>>" + j);
					break;
				}
				count++;
			}
			j++;

		}

	}

	public static boolean isPrime(int n) {
		boolean result = true;
		if (n==0 || n == 1) {
			result = false;
		} else {
			for (int i = 2; i <= n / 2; i++) {
				if (n % i == 0) {
					result = false;
					break;
				} else {
					result = true;
				}
			}
		}
		return result;
	}

}
