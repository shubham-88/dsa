package dsa;

public class StringPermutation {

	public static void main(String[] args) {
		permute(new char[] { 'a', 'b', 'c', 'd' }, 0, 3);

	}

	static void permute(char[] data, int l, int r) {

		if (l == r) {
			System.out.println(String.valueOf(data));
		}
		for (int i = l; i <= r; i++) {
			swap(data, l, i);
			permute(data, l + 1, r);
			swap(data, l, i);
		}

	}

	private static void swap(char[] data, int i, int j) {
		char temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
