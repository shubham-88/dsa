package dsa;

public class CountDer {

	// Permutation such that no element appears in its original position
	public static void main(String[] args) {
		int input = 4;

		System.out.println(countDer(input));

	}

	private static int countDer(int input) {

		if (input == 1)
			return 0;
		if (input == 2)
			return 1;

		return (input - 1) * (countDer(input - 1) + countDer(input - 2));
	}

}
